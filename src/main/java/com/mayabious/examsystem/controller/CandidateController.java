package com.mayabious.examsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.mayabious.examsystem.bean.CandidateBean;
import com.mayabious.examsystem.business.ExamBusinessLogic;
import com.mayabious.examsystem.business.ExamBusinessLogicImpl;
import com.mayabious.examsystem.service.CandidateService;
import com.mayabious.examsystem.service.CandidateServiceImpl;

@RestController
@SessionAttributes("candidateBean")
public class CandidateController 
{
	@Autowired
	CandidateService candidateService;
	
	CandidateBean candidateBean = null;
	
	ExamBusinessLogic examBusinessLogic = null;
	
	String jsonString = "";	
	int status = 0;	
	
	static final Logger LOGGER = Logger.getLogger(CandidateController.class);
	
/*-----------------------------------------------------New Candidate Sing Up----------------------------------------------------------*/	
	
	@RequestMapping(value = "/cSingUp", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView cSingUp(@ModelAttribute ("dataString") CandidateBean candidateBean, BindingResult result)  
	 { 	
		
		examBusinessLogic = new ExamBusinessLogicImpl();
		
		candidateBean = candidateService.saveCInfo(candidateBean);
		
		//jsonString = examBusinessLogic.objectToJsonString(candidateBean);
		if(candidateBean.getcId() != 0)
		{
			return new ModelAndView("candidateHome","candidateBean",candidateBean);
		}		
		else
		{
			return new ModelAndView("index","singUpStatus","Some Problem Not Successfuly... Sing Up");
		}
		
	 }
	
/*-----------------------------------------------------Candidate Sing In---------------------------------------------------------------*/	
	
	@RequestMapping(value = "/cSingIn", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView cSingIn(@RequestParam("cMobile") String cMobile)  
	 {  
		  LOGGER.info("Login INFO");
		  candidateBean = new CandidateBean();
		  
		  examBusinessLogic = new ExamBusinessLogicImpl();
		  
		  candidateBean = candidateService.getCDetails(cMobile);
		  //jsonString = examBusinessLogic.objectToJsonString(candidateBean);
		  
		  System.out.println("Sing Up Successfully : "+candidateBean.getcName());		  
		  LOGGER.info("Sing Up Successfully : "+candidateBean.getcName());
		  
		  if(candidateBean.getcId() != 0)
	  		  return new ModelAndView("candidateHome","candidateBean",candidateBean);
		  else
		  return new ModelAndView("index","loginStatus","You are Not a Register Candidate, Please Sing Up");		  
	 } 
	
/*-----------------------------------------------------Show Candidate Profile-------------------------------------------------------*/	
	
	@RequestMapping(value = "/showCandidateProfile", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView candidateProfile(HttpServletRequest request, HttpSession session)  
	 { 
		candidateBean = new CandidateBean();
		
		
		session = request.getSession();
		candidateBean = (CandidateBean) session.getAttribute("candidateBean");		
		
		System.out.println("CID : "+candidateBean.getcId());
		
		candidateBean = candidateService.getCDetails(candidateBean.getcMobile());		
		
		return new ModelAndView("candidateProfile", "candidateBean", candidateBean);
	 }
	

/*-----------------------------------------------------Update Candidate Profile----------------------------------------------------------*/	
	
	@RequestMapping(value = "/updateCProfile", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView updateCandidateProfile(@ModelAttribute ("dataString") CandidateBean candidateBean, BindingResult result)  
	 { 	
		
		examBusinessLogic = new ExamBusinessLogicImpl();
		
		candidateBean = candidateService.updateCProfile(candidateBean);
		
		return new ModelAndView("candidateProfile", "candidateBean", candidateBean);
	 }


	
	
/*========================================================= SEND IN JSP PAGE =============================================================================*/	
	
/*-----------------------------------------------------Candidate Home Page-------------------------------------------------------------*/	
	
	@RequestMapping(value = "/candidateHomePage", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView candidateHomePage()  
	 {  
		//Check User info
		return new ModelAndView("candidateHome");
	 }
	
/*-----------------------------------------------------Candidate Home Page-------------------------------------------------------------*/
	
	@RequestMapping(value = "/cLogout", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView candidateLogoutPage()  
	 {  
		//Clean all User Information
		return new ModelAndView("index");
	 }
	
}
