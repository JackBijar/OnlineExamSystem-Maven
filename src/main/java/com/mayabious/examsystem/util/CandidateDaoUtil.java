package com.mayabious.examsystem.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class CandidateDaoUtil 
{
	@Autowired
    private SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;
}
