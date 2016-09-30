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
import com.mayabious.examsystem.model.CandidateModel;
import com.mayabious.examsystem.service.CandidateService;
import com.mayabious.examsystem.service.CandidateServiceImpl;

import static com.mayabious.examsystem.constant.Constant.*;



@RestController
@SessionAttributes("candidateModel")
public class CandidateController 
{
	@Autowired
	CandidateService candidateService;
	
	CandidateModel candidateModel = null;
	
	ExamBusinessLogic examBusinessLogic = null;
	
	String jsonString = "";	
	int status = 0;	
	
	static final Logger LOGGER = Logger.getLogger(CandidateController.class);
	
/*-----------------------------------------------------New Candidate Sing Up----------------------------------------------------------*/	
	
	@RequestMapping(value = "/cSingUp", method = RequestMethod.POST, headers="Accept=application/json")  
	 @ResponseBody public ModelAndView cSingUp(@ModelAttribute ("dataString") CandidateModel candidateModel, BindingResult result)  
	 { 
		this.candidateModel = candidateService.saveCInfo(candidateModel);	
		
		if(candidateModel.getcId() != 0)
		{
			return new ModelAndView(C_HOME_PAGE, CANDIDATE_MODEL, candidateModel);
		}		
		else
		{
			return new ModelAndView(INDEX_PAGE, REG_STATUS, NOT_REG_STATUS_MSG);
		}
	 }
	
/*-----------------------------------------------------Candidate Sing In---------------------------------------------------------------*/	
	
	@RequestMapping(value = "/cSingIn", method = RequestMethod.POST, headers="Accept=application/json")  
	 @ResponseBody public ModelAndView cSingIn(@RequestParam("cMobile") String cMobile)  
	 {
		  candidateModel = candidateService.getCDetails(cMobile);
		  
		  if(candidateModel.getcId() != 0)
	  		  return new ModelAndView(C_HOME_PAGE, "candidateModel", candidateModel);
		  else
			  return new ModelAndView(INDEX_PAGE, LOGIN_STATUS, NOT_REG_C_MSG);		  
	 } 
	
/*-----------------------------------------------------Show Candidate Profile-------------------------------------------------------*/	
	
	@RequestMapping(value = "/showCandidateProfile", method = RequestMethod.GET, headers="Accept=application/json")  
	 @ResponseBody public ModelAndView candidateProfile(HttpServletRequest request, HttpSession session)  
	 { 
		candidateModel = new CandidateModel();
		
		session = request.getSession();
		candidateModel = (CandidateModel) session.getAttribute("candidateModel");		
		
		System.out.println("CID : "+candidateModel.getcId());
		
		candidateModel = candidateService.getCDetails(candidateModel.getcMobile());		
		
		return new ModelAndView("candidateProfile", "candidateModel", candidateModel);
	 }
	

/*-----------------------------------------------------Update Candidate Profile----------------------------------------------------------*/	
	
	@RequestMapping(value = "/updateCProfile", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView updateCandidateProfile(@ModelAttribute ("dataString") CandidateModel candidateModel, BindingResult result)  
	 { 			
		examBusinessLogic = new ExamBusinessLogicImpl();
		
		candidateModel = candidateService.updateCProfile(candidateModel);
		
		return new ModelAndView("candidateProfile", "candidateModel", candidateModel);
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
