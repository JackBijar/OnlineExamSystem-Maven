package com.mayabious.examsystem.service;

import java.util.List;

import com.mayabious.examsystem.bean.AdminBean;
import com.mayabious.examsystem.bean.CandidateBean;
import com.mayabious.examsystem.model.AdminModel;

public interface AdminService 
{
	public AdminModel saveAdminInfo(AdminModel adminModel);
	
	public AdminModel getAdminDetails(String adminMobile, String adminPass);
	
	public List<AdminModel> getInActiveAdmin();
	
	public int activeAdminAccess(long adminId);
	
	public CandidateBean getCandidateinfo(long cId);
	
	public int clearExamInfo(long cMobile);
	
}
