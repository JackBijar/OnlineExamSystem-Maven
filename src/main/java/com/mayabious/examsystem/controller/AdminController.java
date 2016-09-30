package com.mayabious.examsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mayabious.examsystem.bean.AdminBean;
import com.mayabious.examsystem.business.ExamBusinessLogic;
import com.mayabious.examsystem.model.AdminModel;
import com.mayabious.examsystem.model.CandidateModel;
import com.mayabious.examsystem.service.AdminService;

import static com.mayabious.examsystem.constant.Constant.INDEX_PAGE;
import static com.mayabious.examsystem.constant.Constant.LOGIN_STATUS;

@RestController
@SessionAttributes("adminBean")
public class AdminController 
{
	@Autowired
	AdminService adminService;
	
	@Autowired
	ExamBusinessLogic examBusinessLogic;
	
	static final Logger LOGGER = Logger.getLogger(AdminController.class);
	AdminModel adminModel = null;
	CandidateModel candidateModel = null;
	
	String jsonString = "";		
	int status = 0;
	long statusId = 0;
	
	List<AdminModel> adminModelList;

/*----------------------------------------------------New Admin Sing Up----------------------------------------------------------------------------------------------------*/	
	
	@RequestMapping(value = "/aSingUp", method = RequestMethod.POST, headers="Accept=application/json")  
	 @ResponseBody public ModelAndView aSingUp(@ModelAttribute ("dataString") AdminModel adminModel, BindingResult result)  
	 {	
		LOGGER.info("Login INFO Test : "+adminModel.getAdminName()+" == "+adminModel.getAdminMobile());
		
		this.adminModel = adminService.saveAdminInfo(adminModel);
		
		return new ModelAndView(INDEX_PAGE, LOGIN_STATUS, "Registration Status Active by Admin");
	 }	
	
/*-----------------------------------------------------Admin Sing In-------------------------------------------------------------------------------------------------------*/	
	
	@RequestMapping(value = "/aSingIn", method = RequestMethod.POST, headers="Accept=application/json")  
	 @ResponseBody public ModelAndView aSingIn(@RequestParam("adminMobile") String adminMobile,
			 								   @RequestParam("adminPass") String adminPass)  
	 { 
		adminModel = adminService.getAdminDetails(adminMobile, adminPass);
		
		if(adminModel.getAdminId() != 0 && adminModel.getAdminRegStatus() != 0)
		{			
			return new ModelAndView("adminHome","adminBean",adminModel);
		}
		else
		{
			return new ModelAndView(INDEX_PAGE, LOGIN_STATUS, "Registration Status is Not Active");
		}		
	 }
	
/*----------------------------------------------------Show All Inactive New Admin------------------------------------------------------------------------------------------*/	
	
	@RequestMapping(value = "/activeNewAdmin", method = RequestMethod.GET, headers="Accept=application/json")  
	 @ResponseBody public ModelAndView activeNewAdmin()  
	 {  		
		adminModelList = new ArrayList<>();	
		
		adminModelList = adminService.getInActiveAdmin();
		
		return new ModelAndView("activeAdmin", "adminBeanList", adminModelList);
	 }
	
/*----------------------------------------------------Activate Admin Access Permission ------------------------------------------------------------------------------------*/	
	
	@RequestMapping(value = "/activeAdminAccess", method = RequestMethod.POST, headers="Accept=application/json")  
	 @ResponseBody public String activeAdminAccess(@ModelAttribute ("adminId") AdminBean adminBean, BindingResult result)  
	 { 	
		adminModelList = new ArrayList<>();
				
		adminService.activeAdminAccess(adminBean.getAdminId());		
		
		adminModelList = adminService.getInActiveAdmin();
		
		jsonString = examBusinessLogic.objectToJsonString(adminModelList);
		
		return jsonString;
	 }
	
/*-----------------------------------------------------Show Candidate Info-------------------------------------------------------------------------------------------------*/
	
	@RequestMapping(value = "/showCandidateInfo", method = RequestMethod.POST, headers="Accept=application/json")  
	 @ResponseBody public String showCandidateInfo(@ModelAttribute ("cId") CandidateModel candidateModel, BindingResult result)  
	 {		
		this.candidateModel = adminService.showCandidateInfo(candidateModel.getcId());		
			
		jsonString = examBusinessLogic.objectToJsonString(candidateModel);
		
		return jsonString;
	 }

/*-----------------------------------------------------Clear Candidate Exam Information [Testing Purpose]------------------------------------------------------------------*/	
	
	@RequestMapping(value = "/clearExamInfo", method = RequestMethod.GET, headers="Accept=application/json")  
	 @ResponseBody public ModelAndView clearExamInfo()  
	 {
		adminService.clearExamInfo();
		
		return new ModelAndView("candidateHome", "message", "Successfully Clear Exam Info");
	 }	
	
	
	
/*========================================================= SEND IN JSP PAGE ==============================================================================================*/
	

	/*----------------------------------------------------Admin Home Page--------------------------------------------------------------------------------------------------*/	
	
	@RequestMapping(value = "/adminHomePage", method = RequestMethod.GET, headers="Accept=application/json")  
	 @ResponseBody public ModelAndView adminHomePage()  
	 {  		
		//Get User Info
		return new ModelAndView("adminHome");
	 }
	
/*----------------------------------------------------Admin Logout---------------------------------------------------------------------------------------------------------*/	

	@RequestMapping(value = "/adminLogout", method = RequestMethod.GET, headers="Accept=application/json")  
	 @ResponseBody public ModelAndView adminLogout()  
	 {  		
		//Remove all Info
		return new ModelAndView(INDEX_PAGE);
	 }	
}
