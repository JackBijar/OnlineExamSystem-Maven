package com.mayabious.examsystem.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.criterion.Restrictions;

import static com.mayabious.examsystem.constant.Constant.HIBERNATE_ERROR_STATUS;

import com.mayabious.examsystem.model.AdminModel;
import com.mayabious.examsystem.model.CandidateModel;

@Repository
public class AdminDaoUtil 
{
	@Autowired
    private SessionFactory sessionFactory;
	
	static final Logger LOGGER = Logger.getLogger(AdminDaoUtil.class);
	
	Session session = null;
	Transaction transaction = null;
	
	AdminModel adminModel = null;
	CandidateModel candidateModel = null;
	
	List<AdminModel> aResultList = null;
	List<CandidateModel> cResultList = null;
	
	String statusMsg = "";
	long statusId = 0;
	
//---------------------------------------------------------------------Save Admin Information-----------------------------------------------------------------------------//
	
	public long saveAdminInfo(AdminModel adminModel) 
	{
		try
		{
			session = sessionFactory.openSession();		
			//session.getTransaction().setTimeout(3);		// Transaction timeout in 3 second 
			
			transaction = session.beginTransaction();
			statusId = (Long) session.save(adminModel);
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
//-----------------------------------------------------------------------------------Admin SingIn------------------------------------------------------------------------//	
	
	@SuppressWarnings("unchecked")
	public AdminModel getAdminDetails(String adminMobile, String adminPass) 
	{
		try
		{
			session = sessionFactory.openSession();	
			transaction = session.beginTransaction();
			aResultList = new ArrayList<>();
			
			aResultList = session.createCriteria(AdminModel.class)
					.add(Restrictions.eq("adminPass", adminPass))
					.add(Restrictions.eq("adminMobile", adminMobile)).list();	
	       
			for (Iterator<AdminModel> iterator = aResultList.iterator(); iterator.hasNext();)
			{
	        	adminModel = iterator.next(); 
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
		return adminModel;
	}
//-------------------------------------------------------------------------------------------Get Inactive Admin Information----------------------------------------------------------------//	
		
	@SuppressWarnings("unchecked")
	public List<AdminModel> getInActiveAdmin(long adminRegStatus) 
 	{ 	
		try
		{
			session = sessionFactory.openSession();	
			transaction = session.beginTransaction();
			aResultList = new ArrayList<>();
			
			aResultList = session.createCriteria(AdminModel.class).add(
									Restrictions.eq("adminRegStatus", adminRegStatus)).list();
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
		return aResultList;
 	}
//-------------------------------------------------------------------------------------------Active Admin Permission-------------------------------------------------------//	
	
	public long activeAdminAccess(long adminId, long adminRegStatus) 
	{
		try
		{
			session = sessionFactory.openSession();	
			transaction = session.beginTransaction();
			
			adminModel = (AdminModel)session.get(AdminModel.class, adminId); 
			
			adminModel.setAdminRegStatus(adminRegStatus);
			
			session.update(adminModel); 
			 
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
		return statusId	;
	}
//--------------------------------------------------------------Get Candidate Details--------------------------------------------------------------------------------------//	
	
	public CandidateModel showCandidateInfo(long cId) 
	{
		try
		{
			session = sessionFactory.openSession();	
			transaction = session.beginTransaction();
			candidateModel = (CandidateModel)session.get(CandidateModel.class, cId);
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
//--------------------------------------------------------------Chear Candidate Info [For Testing Purpose]----------------------------------------------------------------//	
	@SuppressWarnings("unchecked")
	public long clearExamInfo(long cMobile) 
	{
		long cId = 0;
		long reportId = 0;
		
		try
		{
			session = sessionFactory.openSession();	
			transaction = session.beginTransaction();
			cResultList = new ArrayList<>();
			
			cResultList = session.createCriteria(CandidateModel.class)
								.add(Restrictions.eq("cMobile", cMobile)).list();	
	       
			for(CandidateModel candidateModel : cResultList)
			{
				System.out.println("==="+candidateModel.getcEmail());
			}
			
			//candidateModel = (CandidateModel)session.get(CandidateModel.class, cId);
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
		
		/*
		
		try
		{
			con = DBConnectionFactory.getConnection();	
			pst = con.prepareStatement("select c_id from candidate_info where c_mobile = ?");
			pst.setLong(1, cMobile);
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				cId = rs.getLong("c_id");
				System.out.println("cId : "+cId);
			}
			
			pst = con.prepareStatement("select max(report_id) from candidate_report where c_id = ?");
			pst.setLong(1, cId);
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				reportId = rs.getLong(1);
				System.out.println("reportId : "+reportId);
			}
			
			pst = con.prepareStatement("delete from mcq_result where report_id = ?");			
			pst.setLong(1, reportId);
			status = pst.executeUpdate();
			System.out.println("Status =1= "+status);
			if(status > 0)
			{
				System.out.println("Successfully Deleted Mcq Result");	
				status = 0;
			}
			else
				System.out.println("Not Deleted Mcq Result");
			
			pst = con.prepareStatement("delete from descriptive_result where report_id = ?");			
			pst.setLong(1, reportId);
			status = pst.executeUpdate();
			System.out.println("Status =2= "+status);
			if(status > 0)
			{
				status = 0;
				System.out.println("Successfully Deleted Descriptive Result");
			}
			else
				System.out.println("Not Deleted Descriptive Result");
			pst = con.prepareStatement("update candidate_report set mcq_result = ? , desc_result = ?, total = ?, grade = ?,"
											+ "mcq_report_status = ?, desc_report_status = ?, check_desc_report_status = ? "
											+ "where report_id = ?");
			pst.setLong(1, 0);
			pst.setLong(2, 0);
			pst.setLong(3, 0);
			pst.setString(4, "");
			pst.setLong(5, 0);
			pst.setLong(6, 0);
			pst.setLong(7, 0);
			pst.setLong(8, reportId);
			status = pst.executeUpdate();
			if(status > 0)
			{
				System.out.println("Update Successfully");
			}
			else
				System.out.println("Table Not Update");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}		*/
		return statusId;
	}
	
	
	// Basic 
	/*session = sessionFactory.openSession();	
	transaction = session.beginTransaction();
	
	criteria = session.createCriteria(AdminModel.class);
	
	query1 = Restrictions.eq("adminPass", adminPass);
	query2 = Restrictions.eq("adminMobile", adminMobile);
	
	logicalExpression = Restrictions.and(query1, query2);
	
	criteria.add(logicalExpression);

	resultList = criteria.list();	*/
	
	
	
	/*resultList = session.createCriteria(AdminModel.class)
	.add(Restrictions.eq("adminPass", adminPass))
	.add(Restrictions.eq("adminMobile", adminMobile))
	.list();*/

/*.add( Restrictions.like("name", "Fritz%")
.add( Restrictions.between("weight", minWeight, maxWeight) )
Restrictions.isNull("age")
Restrictions.eq( "age", new Integer(0) ),
Restrictions.or*/		
	
	
	/*resultList = session.createCriteria(AdminModel.class).add(Restrictions.and(
	Restrictions.eq("adminPass", adminPass),
	Restrictions.eq("adminMobile", adminMobile)
)).list();	*/
	
	
	/*public List getMaxAdminId()
	{		
		hql = "select max(admin_id) from admin_info";
		
		try
		{
			session = sessionFactory.openSession();			
			query = session.createQuery(hql); 			
			resultList = query.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		finally
		{
			session.close();
		}
		return resultList ;
	}*/
	
	
	/*
	 public <T> Serializable saveAdminInfo(final T entity) 
	 { 
		 return sessionFactory.getCurrentSession().save(entity); 
	 }
	 
	 @SuppressWarnings("unchecked")	
	 public <T> List<T> fetchAll(Class<T> entityClass)
	 {        
		 return sessionFactory.getCurrentSession().createQuery(" FROM "+entityClass.getName()).list();        
	 }
	 
	 @SuppressWarnings("rawtypes")
	 public <T> List fetchAll(String query) 
	 {        
       return sessionFactory.getCurrentSession().createSQLQuery(query).list();        
	 }*/	
}
