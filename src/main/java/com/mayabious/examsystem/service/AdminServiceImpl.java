package com.mayabious.examsystem.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mayabious.examsystem.bean.AdminBean;
import com.mayabious.examsystem.bean.CandidateBean;
import com.mayabious.examsystem.dao.AdminDao;
import com.mayabious.examsystem.dao.AdminDaoImpl;
import com.mayabious.examsystem.model.AdminModel;

@Service
@Transactional
public class AdminServiceImpl implements AdminService 
{	
	@Autowired
	AdminDao adminDao;	
	
	public AdminModel getAdminDetails(String adminMobile, String adminPass) 
	{
				
		return adminDao.getAdminDetails(adminMobile, adminPass);
	}
	
	public AdminModel saveAdminInfo(AdminModel adminModel) 
	{
		
		return adminDao.saveAdminInfo(adminModel);
	}

	
	public List<AdminModel> getInActiveAdmin() 
	{		
			
		return adminDao.getInActiveAdmin();
	}

	
	public int activeAdminAccess(long adminId) 
	{
		
		return adminDao.activeAdminAccess(adminId);
	}

	
	public CandidateBean getCandidateinfo(long cId) 
	{
		
		
		return adminDao.getCandidateinfo(cId);
	}

	
	public int clearExamInfo(long cMobile) 
	{
		
		return adminDao.clearExamInfo(cMobile);
	}

}
