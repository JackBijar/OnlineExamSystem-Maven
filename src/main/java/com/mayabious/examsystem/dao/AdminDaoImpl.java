package com.mayabious.examsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mayabious.examsystem.model.AdminModel;
import com.mayabious.examsystem.model.CandidateModel;
import com.mayabious.examsystem.util.AdminDaoUtil;

import static com.mayabious.examsystem.constant.Constant.LOGGER_STATUS;

import static com.mayabious.examsystem.constant.Constant.INACTIVE_ADMIN_REG_STATUS;
import static com.mayabious.examsystem.constant.Constant.ACTIVE_ADMIN_REG_STATUS;
import static com.mayabious.examsystem.constant.Constant.TEST_MOBILE_NO;



@Repository
public class AdminDaoImpl implements AdminDao 
{	
	@Autowired
	private AdminDaoUtil adminDaoUtil;
	
	static final Logger LOGGER = Logger.getLogger(AdminDaoUtil.class);
		
	AdminModel adminModel = null;	
	CandidateModel candidateModel = null;
	
	List<AdminModel> adminModelList = null;	
	
	String statusMsg;
	long statusId;	
	
	
//--------------------------------------------------------------------Save Admin Information------------------------------------------------------------------------------//
	@Override
	public AdminModel saveAdminInfo(AdminModel adminModel) 
	{
		statusId = (Long) adminDaoUtil.saveAdminInfo(adminModel);
		
		if(statusId > 0)
		{
			adminModel.setAdminId(statusId);
			LOGGER.info(LOGGER_STATUS + "Admin Information Save Successfully");
		}			
		else
		{
			LOGGER.info(LOGGER_STATUS + "Admin Information Not Successfully Save");
		}			
		return adminModel;
	}	
//-----------------------------------------------------------------------------------Admin SingIn------------------------------------------------------------------------//	
	@Override
	public AdminModel getAdminDetails(String adminMobile, String adminPass) 
	{
		adminModel = adminDaoUtil.getAdminDetails(adminMobile, adminPass);
		
		if(adminModel != null)
		{			
			LOGGER.info(LOGGER_STATUS + "Admin Successfully SingIn");
		}			
		else
		{
			LOGGER.info(LOGGER_STATUS + "Admin Not Successfully SingIn");
		}	
		return adminModel;
	}
//-----------------------------------------------------------------------------------Get Inactive Admin Information-------------------------------------------------------------------//	
	@Override
	public List<AdminModel> getInActiveAdmin() 
 	{ 
		adminModelList = new ArrayList<>();
		
		adminModelList = adminDaoUtil.getInActiveAdmin(INACTIVE_ADMIN_REG_STATUS);
		
		if(adminModelList != null)
		{			
			LOGGER.info(LOGGER_STATUS + "Get Inactive Admin Information Successfully");
		}			
		else
		{
			LOGGER.info(LOGGER_STATUS + "Not Get Inactive Admin Information Successfully");
		}	
		return adminModelList;
	}
//-------------------------------------------------------------------------------Active Admin Permission-------------------------------------------------------------------//
	@Override
	public void activeAdminAccess(long adminId) 
	{
		statusId = adminDaoUtil.activeAdminAccess(adminId, ACTIVE_ADMIN_REG_STATUS);
		
		if(statusId > 0)
		{			
			LOGGER.info(LOGGER_STATUS + "Aactive Admin Permission Successfully");
		}			
		else
		{
			LOGGER.info(LOGGER_STATUS + "Admin Permission Not active");
		}
	}

//--------------------------------------------------------------Get Candidate Details--------------------------------------------------------------------------------------//
	@Override
	public CandidateModel showCandidateInfo(long cId) 
	{		
		candidateModel =  adminDaoUtil.showCandidateInfo(cId);
			
		if(candidateModel != null)
		{			
			LOGGER.info(LOGGER_STATUS + "Successfully retrive Candidate information");
		}			
		else
		{
			LOGGER.info(LOGGER_STATUS + "Not successfully retrive Candidate information");
		}
		return candidateModel;
	}

/*------------------------------------------------------------Chear Candidate Info [For Testing Purpose]-------------------------------------------------------------------*/	
	@Override
	public void clearExamInfo() 
	{
		statusId = adminDaoUtil.clearExamInfo(TEST_MOBILE_NO);
		
		if(statusId > 0)
		{			
			LOGGER.info(LOGGER_STATUS + "Candidate Exam information Successfully Clear");
		}			
		else
		{
			LOGGER.info(LOGGER_STATUS + "Candidate Exam information Not Successfully Clear");
		}
	}
}
