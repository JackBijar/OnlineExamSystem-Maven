package com.mayabious.examsystem.dao;

import java.util.List;

import com.mayabious.examsystem.model.AdminModel;
import com.mayabious.examsystem.model.CandidateModel;

public interface AdminDao 
{
	public AdminModel getAdminDetails(String adminMobile, String adminPass);
	
	public AdminModel saveAdminInfo(AdminModel adminModel);
	
	public List<AdminModel> getInActiveAdmin();
	
	public void activeAdminAccess(long adminId);
	
	public CandidateModel showCandidateInfo(long cId);
	
	public void clearExamInfo();
}
