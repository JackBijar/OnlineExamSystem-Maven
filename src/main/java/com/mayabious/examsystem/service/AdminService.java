package com.mayabious.examsystem.service;

import java.util.List;

import com.mayabious.examsystem.bean.AdminBean;
import com.mayabious.examsystem.bean.CandidateBean;
import com.mayabious.examsystem.model.AdminModel;
import com.mayabious.examsystem.model.CandidateModel;

public interface AdminService 
{
	public AdminModel saveAdminInfo(AdminModel adminModel);
	
	public AdminModel getAdminDetails(String adminMobile, String adminPass);
	
	public List<AdminModel> getInActiveAdmin();
	
	public void activeAdminAccess(long adminId);
	
	public CandidateModel showCandidateInfo(long cId);
	
	public void clearExamInfo();
	
}
