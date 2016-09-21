package com.mayabious.examsystem.util;

import java.io.Serializable;

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
	Transaction tx = null;
	long status;

	public long saveAdminInfo(AdminModel adminModel) 
	{
		try
		{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			status = (long) session.save(adminModel);
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
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
