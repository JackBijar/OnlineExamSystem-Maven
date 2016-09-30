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
import com.mayabious.examsystem.model.CandidateModel;

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

	
	public void activeAdminAccess(long adminId) 
	{		
		adminDao.activeAdminAccess(adminId);
	}

	
	public CandidateModel showCandidateInfo(long cId) 
	{
		return adminDao.showCandidateInfo(cId);
	}

	
	public void clearExamInfo() 
	{		
		adminDao.clearExamInfo();
	}

}
