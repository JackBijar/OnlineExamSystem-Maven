package com.mayabious.examsystem.util;

import static com.mayabious.examsystem.constant.Constant.HIBERNATE_ERROR_STATUS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.mayabious.examsystem.dao.CandidateDaoImpl;
import com.mayabious.examsystem.model.AdminModel;
import com.mayabious.examsystem.model.CandidateModel;

public class CandidateDaoUtil 
{
	@Autowired
    private SessionFactory sessionFactory;
	
	static final Logger LOGGER = Logger.getLogger(CandidateDaoUtil.class);
	
	Session session = null;
	Transaction transaction = null;
	
	CandidateModel candidateModel = null;
	
	List<CandidateModel> cResultList = null;
	
	String statusMsg = "";
	long statusId = 0;
	
	
//-------------------------------------------------------------------------Check Candidate Already Register Or Not----------------------------------------------------------	
	@SuppressWarnings("unchecked")
	public CandidateModel checkRegister(String cMobile)
	{
		try
		{
			session = sessionFactory.openSession();	
			transaction = session.beginTransaction();
			
			cResultList = new ArrayList<>();
			
			cResultList = session.createCriteria(CandidateModel.class)
					.add(Restrictions.eq("cMobile", cMobile)).list();
			
			if(cResultList != null)
			{
				for (Iterator<CandidateModel> iterator = cResultList.iterator(); iterator.hasNext();)
				{
					candidateModel = iterator.next(); 
		        }
			}							
			transaction.commit();		
		}
		catch(HibernateException e)
		{
			LOGGER.info(HIBERNATE_ERROR_STATUS + e);			
			if (transaction != null) 
					transaction.rollback();
		}
		finally
		{
			session.close();
		}
		return candidateModel;
	}
//-----------------------------------------------------------------------------Reset Candidate Information------------------------------------------------------------------	

	public long reSetCandidateInfo(long cId, int cStatus)
	{
		try
		{
			session = sessionFactory.openSession();	
			transaction = session.beginTransaction();
			
			candidateModel = (CandidateModel)session.get(CandidateModel.class, cId); 
			
			candidateModel.setcStatus(cStatus+1);	// Increment by 1
			
			session.update(candidateModel); 
			 
			transaction.commit(); 
			 
			if(transaction.wasCommitted())
				 statusId = 1;		 
		}
		catch(HibernateException e)
		{
			LOGGER.info(HIBERNATE_ERROR_STATUS + e);			
			if (transaction != null) 
					transaction.rollback();
		}
		finally
		{
			session.close();
		}	
		return statusId;
	}
	
//-----------------------------------------------------------------------------Save Candidate Information--------------------------------------------------------------------	
	
	public long saveCInfo(CandidateModel candidateModel) 
	{
		try
		{
			session = sessionFactory.openSession();	
			transaction = session.beginTransaction();
			
			statusId = (Long) session.save(candidateModel);
			
			transaction.commit();			
		}
		catch(HibernateException e)
		{
			LOGGER.info(HIBERNATE_ERROR_STATUS + e);			
			if (transaction != null) 
					transaction.rollback();
		}
		finally
		{
			session.close();
		}
		return statusId;
	}
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
}
