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
import com.mayabious.examsystem.bean.CandidateBean;
import com.mayabious.examsystem.business.ExamBusinessLogic;
import com.mayabious.examsystem.model.AdminModel;
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
	AdminModel adminModel;
	
	String jsonString = "";		
	int status = 0;
	
	List<AdminModel> adminModelList;

/*----------------------------------------------------New Admin Sing Up--------------------------------------------------------------*/	
	
	@RequestMapping(value = "/aSingUp", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView aSingUp(@ModelAttribute ("dataString") AdminModel adminModel, BindingResult result)  
	 { 				
		System.out.println(adminModel.getAdminName()+" == "+adminModel.getAdminMobile());
		LOGGER.info("Login INFO Test : "+adminModel.getAdminName()+" == "+adminModel.getAdminMobile());
		
		adminModel = adminService.saveAdminInfo(adminModel);
		
		/*jsonString = examBusinessLogic.objectToJsonString(adminBean);			
		return jsonString;*/	
		
		return new ModelAndView(INDEX_PAGE, LOGIN_STATUS, "Registration Status Active by Admin");
	 }	
	
/*-----------------------------------------------------Admin Sing In------------------------------------------------------------------*/	
	
	@RequestMapping(value = "/aSingIn", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView aSingIn(@RequestParam("adminMobile") String adminMobile,
			 								   @RequestParam("adminPass") String adminPass)  
	 {  
		System.out.println("adminPass : "+adminPass+" adminMobile :"+adminMobile);
		
		adminModel = adminService.getAdminDetails(adminMobile, adminPass);
		
		if(adminModel.getAdminId() != 0 && adminModel.getAdminRegStatus() != 0)
		{			
			System.out.println("IDDD :"+adminModel.getAdminId());
			//jsonString = examBusinessLogic.objectToJsonString(adminBean);
			return new ModelAndView("adminHome","adminBean",adminModel);
		}
		else
		{
			return new ModelAndView(INDEX_PAGE, LOGIN_STATUS, "Registration Status is Not Active");
		}		
	 }
	
/*----------------------------------------------------Show All Inactive New Admin----------------------------------------------------------*/	
	
	@RequestMapping(value = "/activeNewAdmin", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView activeNewAdmin()  
	 {  		
		adminModelList = new ArrayList<AdminModel>();	
		
		adminModelList = adminService.getInActiveAdmin();
		
		return new ModelAndView("activeAdmin", "adminBeanList", adminModelList);
	 }
	
/*----------------------------------------------------Activate Admin Access permission ---------------------------------------------------------------*/	
	
	@RequestMapping(value = "/activeAdminAccess", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody String activeAdminAccess(@ModelAttribute ("adminId") AdminBean adminBean, BindingResult result)  
	 {   	
		
		adminModelList = new ArrayList<AdminModel>();
		
		System.out.println("adminId "+adminBean.getAdminId());	
		
		status = adminService.activeAdminAccess(adminBean.getAdminId());		
		if(status > 0)
		{
			System.out.println("Activated");
			adminModelList = adminService.getInActiveAdmin();
			jsonString = examBusinessLogic.objectToJsonString(adminModelList);
		}
		else
			System.out.println("Not Activated");
		
		return jsonString;
	 }
	
	
/*-----------------------------------------------------Show Candidate Info----------------------------------------------------------------------------*/
	
	@RequestMapping(value = "/showCandidateInfo", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody String showCandidateInfo(@ModelAttribute ("cId") CandidateBean candidateBean, BindingResult result)  
	 { 
		System.out.println("CID : "+candidateBean.getcId());
		
		candidateBean = adminService.getCandidateinfo(candidateBean.getcId());
		if(candidateBean != null)
		{
			System.out.println(candidateBean.getcMobile());
			jsonString = examBusinessLogic.objectToJsonString(candidateBean);
		}
		else
		{
			System.out.println("Data Not Found");
			jsonString = "Data Not Found";
		}
		return jsonString;
	 }

/*-----------------------------------------------------Clear Candidate Exam Information [Testing Purpose]----------------------------------------------------------*/	
	
	@RequestMapping(value = "/clearExamInfo", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView clearExamInfo()  
	 { 	
		
		status = adminService.clearExamInfo(0);	//Hard Codded Mobile No '0'
		
		return new ModelAndView("candidateHome", "message", "Successfully Clear Exam Info");
	 }	
	
/*========================================================= SEND IN JSP PAGE =============================================================================*/
	
/*----------------------------------------------------Admin Home Page--------------------------------------------------------------------------------*/	
	
	@RequestMapping(value = "/adminHomePage", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView adminHomePage()  
	 {  		
		//Get User Info
		return new ModelAndView("adminHome");
	 }
	
/*----------------------------------------------------Admin Logout-------------------------------------------------------------------------------------*/	

	@RequestMapping(value = "/adminLogout", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView adminLogout()  
	 {  		
		//Remove all Info
		return new ModelAndView(INDEX_PAGE);
	 }	
	
}
