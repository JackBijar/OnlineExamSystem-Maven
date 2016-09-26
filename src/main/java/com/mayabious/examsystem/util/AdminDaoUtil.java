package com.mayabious.examsystem.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mayabious.examsystem.bean.AdminBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import com.mayabious.examsystem.model.AdminModel;

@Repository
public class AdminDaoUtil 
{
	@Autowired
    private SessionFactory sessionFactory;
	
	Session session = null;
	Transaction transaction = null;
	Query query = null;
	String hql = ""; 
	
	List resultList;
	String status;
	long result;

	/*public long saveAdminInfo(AdminModel adminModel) 
	{
		try
		{
			session = sessionFactory.openSession();
			
			//session.getTransaction().setTimeout(3);		// Transaction timeout in 3 second 
			
			transaction = session.beginTransaction();
			result = (long) session.save(adminModel);
			transaction.commit();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			session.close();
		}
		return result;
	} */
	
	 public <T> Serializable saveAdminInfo(final T entity) 
	 {      
	        session = sessionFactory.openSession();
	        transaction = session.beginTransaction();
	        result = (long) session.save(entity);
	        //sessionFactory.getCurrentSession().save(entity);  
	        return result;
	 }
	
	/*public AdminModel getAdminDetails(String adminMobile, String adminPass) 
	{
		
	}*/
	
	
	
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
	
	
	
	public long getMaxId()
	{
			return 00;	
	}
	
	
	
	
	
	
	
	
	
	
	/*public <T> Serializable create(final T entity) 
	{
        System.out.println("Before Session Factory");
		return sessionFactory.getCurrentSession().save(entity); 
    }*/
}
