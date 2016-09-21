package com.mayabious.examsystem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mayabious.examsystem.bean.CandidateBean;
import com.mayabious.examsystem.bean.DescriptiveQBean;
import com.mayabious.examsystem.bean.ErrorMessageBean;
import com.mayabious.examsystem.bean.ExamReportBean;
import com.mayabious.examsystem.bean.McqBean;
import com.mayabious.examsystem.bean.QuestionCategoryBean;
import com.mayabious.examsystem.bean.QuestionModelBean;
import com.mayabious.examsystem.bean.QuestionSubCategoryBean;
import com.mayabious.examsystem.business.ExamBusinessLogic;
import com.mayabious.examsystem.business.ExamBusinessLogicImpl;
import com.mayabious.examsystem.service.ExamService;
import com.mayabious.examsystem.service.ExamServiceImpl;

@RestController
@SessionAttributes("candidateBean")
public class ExamController 
{
	@Autowired
	ExamService examService;
	
	ObjectMapper objectMapper = null;
	
	McqBean mcqBean = null;
	DescriptiveQBean descriptiveQBean = null;
	ExamBusinessLogic examBusinessLogic = null;
	CandidateBean candidateBean = null;
	ExamReportBean examReportBean = null;
	ErrorMessageBean errorMessageBean = null;
	
	Map<Long, Long> mcqResultMap = null;
	Map<Long, String> descResultMap = null;
	Map<Long, Long> descSaveMarksMap = null;
	List<McqBean> mcqBeanList = null;
	List<DescriptiveQBean> descriptiveQBeanList = null;
	List<ExamReportBean> examReportBeanList = null;
	List<QuestionCategoryBean> questionCategoryBeanList = null;
	List<QuestionSubCategoryBean>  questionSubCategoryBeanList = null;
	List<QuestionModelBean> questionModelBeanList = null;
	
	String jsonString = "";		
	int status = 0;
	
/*=========================================================== MCQ QUESTION PORTION =================================================================================*/	
	
/*----------------------------------------------------Select Question Category for Add New MCQ------------------------------------------------------------------*/
	
	@RequestMapping(value = "/selectQCategory", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody String selectQCategory()  
	 {
		
		examBusinessLogic = new ExamBusinessLogicImpl();
		errorMessageBean = new ErrorMessageBean();
		
		questionCategoryBeanList = new ArrayList<QuestionCategoryBean>();	
		
		questionCategoryBeanList = examService.showQCategory();
		
		if(questionCategoryBeanList.size() > 0)
		{
			jsonString = examBusinessLogic.objectToJsonString(questionCategoryBeanList);
		}
		else
		{
			errorMessageBean.setMessage("Data Not Found");
			jsonString = examBusinessLogic.objectToJsonString(errorMessageBean);
		}		
		return jsonString;		
	 }

	
/*----------------------------------------------------Add MCQ Question--------------------------------------------------------------------*/
	
	@RequestMapping(value = "/addMcqQuestion", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView addMcqQuestion(@ModelAttribute ("dataString") McqBean mcqBean, BindingResult result)  
	 {  
		System.out.println("In addMcqQuestion =:= "+mcqBean.getMcqCorrectId());
		
		
		
		mcqBean = examService.addMcqQuestion(mcqBean);		
		
		return new ModelAndView("addMcqQuestion","message","Save Successfully");
	 }	
	
/*--------------------------------------------------View All MCQ Question------------------------------------------------------------------*/
	
	@RequestMapping(value = "/showAllMcq", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView showAllMcq()  
	 {  
		System.out.println("In Show MCQs Controller");
		mcqBean = new McqBean();
		
		//examBusinessLogic = new ExamBusinessLogicImpl();
		mcqBeanList = new ArrayList<McqBean>();
		
		mcqBeanList = examService.showAllMcq();
		
		/*if(mcqBeanList.size() > 0)
			jsonString = examBusinessLogic.objectToJsonString(mcqBeanList);
		else
			jsonString = "No Data Found";		
		return jsonString;*/
		
		return new ModelAndView("showAllMcqQuestions", "mcqBeanList", mcqBeanList);
	 }	

/*----------------------------------------------------Update MCQ Question------------------------------------------------------------------*/
	
	@RequestMapping(value = "/updateMcqQuestion", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView updateMcqQuestion(@ModelAttribute ("dataString") McqBean mcqBean, BindingResult result)  
	 {  
		System.out.println("In addMcqQuestion"+mcqBean.getMcqQuestion());
		
		
		
		System.out.println("==="+mcqBean.getMcqQuestion());
		
		mcqBean = examService.updateMcqQuestion(mcqBean);		
		
		return new ModelAndView("redirect:/showAllMcq");
	 }	
	
/*----------------------------------------------------Delete MCQ Question----------------------------------------------------------------*/
		
	@RequestMapping(value = "/deleteMcqQuestion", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody String deleteMcqQuestion(@PathParam("mcqId") long mcqId)  
	 {  
		System.out.println("In mcqId "+mcqId);
		mcqBean = new McqBean();
		
		mcqBeanList = new ArrayList<McqBean>();
		examBusinessLogic = new ExamBusinessLogicImpl();
		
		status = examService.deleteMcqQuestion(mcqId);	/*---Delete Question---*/
		
		if(status > 0)
		{
			mcqBeanList = examService.showAllMcq();				/*---Fetch Question---*/
		}		
		if(mcqBeanList.size() > 0)
			jsonString = examBusinessLogic.objectToJsonString(mcqBeanList);
		else
			jsonString = "No Data Found";
		return jsonString;
	 }		
	

/*========================================================= DESCRIPTIVE QUESTION PORTION =============================================================================*/	
	
/*------------------------------------------------Add New Descriptive Question-----------------------------------------------------------------*/
	
	@RequestMapping(value = "/addDescQuestion", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView addDescQuestion(@ModelAttribute ("dataString") DescriptiveQBean descriptiveQBean, BindingResult result)  
	 {  
		System.out.println("Question : "+descriptiveQBean.getdQuestion());
		
		
		descriptiveQBean = examService.addDescQuestion(descriptiveQBean);	
		
		return new ModelAndView("addDescQuestion", "message", "Successfully Save");
	 }

/*------------------------------------------------View All Descriptive Question------------------------------------------------------------------*/	
	
	@RequestMapping(value = "/showAllDescQuestion", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView showAllDescQuestion()  
	 {  
		System.out.println("In showAllDescQuestion");
		mcqBean = new McqBean();
		
		descriptiveQBeanList = new ArrayList<DescriptiveQBean>();
		
		descriptiveQBeanList = examService.showAllDescQuestion();
		
		return new ModelAndView("showAllDescQuestion", "descriptiveQBeanList", descriptiveQBeanList);
	 }	
	
/*----------------------------------------------------Update Descriptive Question------------------------------------------------------------------*/
	
	@RequestMapping(value = "/updateDescQuestion", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView updateDescQuestion(@ModelAttribute ("dataString") DescriptiveQBean descriptiveQBean, BindingResult result)  
	 {  
		System.out.println("Question : "+descriptiveQBean.getdQuestion()+"QID :: "+descriptiveQBean.getdQuestionId()+"ANS : "+descriptiveQBean.getcGivenAns());
		
		
		descriptiveQBean = examService.updateDescQuestion(descriptiveQBean);	
		
		return new ModelAndView("redirect:/showAllDescQuestion");
	 }
	
/*----------------------------------------------------Delete Descriptive Question------------------------------------------------------------------*/
	
	@RequestMapping(value = "/deleteDescQuestion", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody String deleteDescQuestion(@PathParam("dQuestionId") long dQuestionId)  
	 {  
		System.out.println("In dQuestionId "+dQuestionId);
		
		descriptiveQBean = new DescriptiveQBean(); 
		
		examBusinessLogic = new ExamBusinessLogicImpl();
		descriptiveQBeanList = new ArrayList<DescriptiveQBean>();
				
		status = examService.deleteDescQuestion(dQuestionId);			//---Delete Descriptive Question---
		
		if(status > 0)
		{
			descriptiveQBeanList = examService.showAllDescQuestion();	//---Fetch Descriptive Question---
		}		
		if(descriptiveQBeanList.size() > 0)
			jsonString = examBusinessLogic.objectToJsonString(descriptiveQBeanList);
		else
			jsonString = "No Data Found";
		return jsonString;
	 }	
	
	
/*========================================================= MCQ EXAMINATION PORTION =============================================================================*/
	
/*---------------------------------------------------- MCQ Examination --------------------------------[For Candidate]--------------------------*/
	
	@RequestMapping(value = "/mcqExamQuestion", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView mcqExamination(HttpServletRequest request, HttpSession session)  
	 {
		
		mcqBeanList = new ArrayList<McqBean>();		
		
		session = request.getSession();
		candidateBean = (CandidateBean) session.getAttribute("candidateBean");		
		
		status = examService.checkMcqExamStatus(candidateBean.getcId());
		
		if(status > 0)
		{
			mcqBeanList = examService.showAllMcq();				/*---Fetch Question---*/
		}
		else
		{
			return new ModelAndView("candidateErrorMessage", "mcqExamMessage", "Mcq Exam Alredy Done.");
		}
		
		for(McqBean mcqBean : mcqBeanList)
		{
			System.out.println("===>"+mcqBean.getMcqQuestion());
		}
		
		return new ModelAndView("mcqExam", "mcqBeanList", mcqBeanList);
	 }
	
/*-----------------------------------------------------Save MCQ Examination Result-------------------------------------[For Candidate]-----------------------------*/
		 
	@RequestMapping(value = "/saveMcqResult", method = RequestMethod.POST, headers="Accept=application/json")  
	public @ResponseBody String saveMcqResult(@PathParam("mcqResult") String mcqResult)  
	 { 			
		
		examBusinessLogic = new ExamBusinessLogicImpl();
		examReportBean = new ExamReportBean();
		
		mcqBeanList = new ArrayList<McqBean>();	
		mcqResultMap = new HashMap<Long, Long>();		
		
		mcqResultMap = examBusinessLogic.putJsonValueToMap(mcqResult);		
		
		long cId = candidateBean.getcId();							/*---Fetch cId from Session----*/
		System.out.println("CID =:=:= "+cId);
		
		examReportBean = examService.saveCandidateMcqAns(mcqResultMap, cId);
		
		if(examReportBean != null)
		{
			System.out.println("Successfully Save");	
			jsonString = examBusinessLogic.objectToJsonString(examReportBean);
		}
		else
			System.out.println("Not Successfully Save");
		return jsonString;
	 }
	

/*========================================================= DESCRIPTIVE QUESTION PORTION =============================================================================*/
	
/*-------------------------------------------- Show Descriptive Examination Question--------------------------------------[For Candidate]------------------*/
	
	@RequestMapping(value = "/descriptiveExamination", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView descriptiveExamination(HttpServletRequest request, HttpSession session)  
	 {	
		
		descriptiveQBeanList = new ArrayList<DescriptiveQBean>();
		
		session = request.getSession();
		candidateBean = (CandidateBean) session.getAttribute("candidateBean");
		
		status = examService.checkDescExamStatus(candidateBean.getcId());
		
		if(status > 0)
		{
			descriptiveQBeanList = examService.showAllDescQuestion();				/*---Fetch Question---*/
		}
		else
		{
			return new ModelAndView("candidateErrorMessage", "descExamMessage", "Descriptive Exam Alredy Done.");
		}
		
		for(DescriptiveQBean descriptiveQBean : descriptiveQBeanList)
		{
			System.out.println(descriptiveQBean.getdQuestion());
		}	
		
		return new ModelAndView("descriptiveExam", "descriptiveQBeanList", descriptiveQBeanList);
	 }	

/*----------------------------------------------------- Save Descriptive Examination ---------------------------------------[For Candidate]--------------------*/
	
	@RequestMapping(value = "/saveDescResult", method = RequestMethod.POST, headers="Accept=application/json")  
	public @ResponseBody String saveDescResult(@PathParam("descResult") String descResult)  
	 { 	
		
		examBusinessLogic = new ExamBusinessLogicImpl();
		
		descriptiveQBeanList = new ArrayList<DescriptiveQBean>();	
		descResultMap = new HashMap<Long, String>();
		
		descResultMap = examBusinessLogic.putJsonValueToMapForDescQ(descResult);		
		
		long cId = candidateBean.getcId();							//---Fetch cId from Session----
		System.out.println("CID =:=:= "+cId);
		
		examReportBean = examService.saveCandidateDescAns(descResultMap, cId);
		
		if(examReportBean != null)
		{
			System.out.println("Successfully Save");	
			jsonString = examBusinessLogic.objectToJsonString(examReportBean);
		}
		else
			System.out.println("Not Successfully Save");
		
		return jsonString;
	 }
	
	
/*--------------------------------------------- Unchecked Candidate List for Descriptive Result -------------------------[For Admin]---------------*/		
	
	@RequestMapping(value = "/fetchDescUncheckCandidate", method = RequestMethod.GET, headers="Accept=application/json")  
	public @ResponseBody ModelAndView fetchDescUncheckCandidate()  
	 { 			
		System.out.println("IN..........");
		examReportBeanList = new ArrayList<ExamReportBean>();
		
		
		examReportBeanList = examService.fetchDescUncheckCandidate();		
		
		return new ModelAndView("checkDescriptive", "examReportBeanList", examReportBeanList);
	 }
	
/*-------------------------------------------------------Fetch Descriptive Answers ------------------------------------------[For Admin]------------*/
	
	@RequestMapping(value = "/checkDescAns", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody String checkDescAns(@PathParam("reportId") long reportId)  
	 {  
		System.out.println("In dQuestionId "+reportId);
		
		descriptiveQBeanList = new ArrayList<DescriptiveQBean>();
		
		
		examBusinessLogic = new ExamBusinessLogicImpl();		
				
		descriptiveQBeanList = examService.checkDescAns(reportId);		//---Check Descriptive Ans---
		
			
		if(descriptiveQBeanList.size() > 0)
			jsonString = examBusinessLogic.objectToJsonString(descriptiveQBeanList);
		else
			jsonString = "No Data Found";
		return jsonString;
	 }		
	
/*-----------------------------------------------------Save Descriptive Result Marks--------------------------------------[For Admin]--------------------*/

	@RequestMapping(value = "/saveDescMarks", method = RequestMethod.POST, headers="Accept=application/json")  
	 public @ResponseBody String saveDescMarks(@PathParam("descMarks") String descMarks,
			 									@PathParam("reportId") long reportId)  
	 {  
		System.out.println("In dQuestionId...... "+descMarks+" AND reportId = "+reportId);
		examBusinessLogic = new ExamBusinessLogicImpl();
		
		descSaveMarksMap = new HashMap<Long, Long>();
		examReportBeanList = new ArrayList<ExamReportBean>();
		
		descSaveMarksMap = examBusinessLogic.putJsonValueToMap(descMarks);	
		
		examReportBeanList = examService.saveDescMarks(reportId, descSaveMarksMap);
		
		for(ExamReportBean bean : examReportBeanList)
		{
			System.out.println("IDDDDD ::: "+bean.getcId());
		}
		
		if(descriptiveQBeanList.size() > 0)
			jsonString = examBusinessLogic.objectToJsonString(examReportBeanList);
		else
			jsonString = "No Data Found";
		return jsonString;
	 }	
	
/*========================================================= VIEW CANDIDATE REPORT =============================================================================*/	
	
/*------------------------------------------------------View Candidate Report------------------------------------------[For Admin]------------------------*/
	
	@RequestMapping(value="/viewCandidateReport", method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody ModelAndView viewCandidateReport()
	{
		examReportBeanList = new ArrayList<ExamReportBean>();
		System.out.println("In viewCandidate Result");
		
		
		examReportBeanList = examService.viewCandidateReport();
		
		System.out.println("examReportBeanList "+examReportBeanList.size());
		
		return new ModelAndView("showCandidateReport", "examReportBeanList", examReportBeanList);
	}	
	

/*========================================================= CANDIDATE PORTION =============================================================================*/
	
/*------------------------------------------------------Check MCQ Result------------------------------------------------------------------------------------*/

	@RequestMapping(value = "/checkMcqResultReport", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView checkMcqResult(HttpServletRequest request, HttpSession session)  
	 {  
		System.out.println("In checkMcq ResultReport");
		List<McqBean> mcqBeanList= new ArrayList<McqBean>();
		
		
		session = request.getSession();
		candidateBean = (CandidateBean) session.getAttribute("candidateBean");
		
		long cId = candidateBean.getcId();	/*---Fetch cId from Session----*/
		System.out.println("CID =:=:= "+cId);
		
		mcqBeanList = examService.getCandidateMcqReport(cId);
		for(McqBean mcqBean : mcqBeanList)
		{
			System.out.println(mcqBean.getcGivenAnsId());
			System.out.println(mcqBean);
		}
		
		return new ModelAndView("mcqReportForCandidate","mcqBeanList",mcqBeanList);
	 }	
	
	
	
/*=========================================================== MCQ QUESTION PORTION =================================================================================*/	
	
/*----------------------------------------------------Add Question Categories-----------------------------------------------------------*/
		
		@RequestMapping(value = "/addQCategory", method = RequestMethod.POST, headers="Accept=application/json")  
		 public @ResponseBody ModelAndView addQCategory(@ModelAttribute ("dataString") QuestionCategoryBean questionCategoryBean, BindingResult result)  
		 {  
			System.out.println("In addMcqQuestion : "+questionCategoryBean.getqCategoryName());
			
			
			
			questionCategoryBean = examService.addQCategory(questionCategoryBean);		
			
			return new ModelAndView("addQCategory","message","Save Successfully");
		 }		

/*----------------------------------------------------Show All Question Categories--------------------------------------------*/
		
		@RequestMapping(value = "/showQCategory", method = RequestMethod.GET, headers="Accept=application/json")  
		 public @ResponseBody ModelAndView showQCategory()  
		 {  
			mcqBean = new McqBean();
			
			
			questionCategoryBeanList = new ArrayList<QuestionCategoryBean>();
			
			questionCategoryBeanList = examService.showQCategory();
			
			return new ModelAndView("showQCategory","questionCategoryBeanList",questionCategoryBeanList);
		 }	
		
/*----------------------------------------------------Delete Question Categories------------------------------------------------------------------*/
		
		@RequestMapping(value = "/deleteQCategory", method = RequestMethod.POST, headers="Accept=application/json")  
		 public @ResponseBody String deleteQCategory(@PathParam("qCategoryId") long qCategoryId)  
		 {  
			System.out.println("In qCategoryId "+qCategoryId);
			
			
			examBusinessLogic = new ExamBusinessLogicImpl();
			
			questionCategoryBeanList = new ArrayList<QuestionCategoryBean>();
					
			status = examService.deleteQCategory(qCategoryId);			//---Delete Descriptive Question---			
			if(status > 0)
			{
				questionCategoryBeanList = examService.showQCategory();	//---Fetch Question Category---
			}	
			
			if(questionCategoryBeanList.size() > 0)
				jsonString = examBusinessLogic.objectToJsonString(questionCategoryBeanList);
			else
				jsonString = "No Data Found";
			return jsonString;
		 }	

/*----------------------------------------------------Update Question Category------------------------------------------------------------------*/
		
		@RequestMapping(value = "/updateQCategory", method = RequestMethod.POST, headers="Accept=application/json")  
		 public @ResponseBody ModelAndView updateQCategory(@ModelAttribute ("dataString") QuestionCategoryBean questionCategoryBean, BindingResult result)  
		 {  
			System.out.println("getqCategoryId : "+questionCategoryBean.getqCategoryId()+"QID :: "+questionCategoryBean.getqCategoryName());
			
			
			questionCategoryBean = examService.updateQCategory(questionCategoryBean);	
			
			return new ModelAndView("redirect:/showQCategory");
		 }	
		
		
		
/*========================================================= Model Question ============================================================================*/
		
/*--------------------------------Search(By Str) Question Category for Add New Model--------------------------------------------------------*/
		
		@RequestMapping(value = "/searchQCategory", method = RequestMethod.POST, headers="Accept=application/json")  
		 public @ResponseBody String searchQCategory(@PathParam("searchQCategoryStr") String searchQCategoryStr)  
		 {  
			System.out.println("Searching String : "+searchQCategoryStr);
			
			
			examBusinessLogic = new ExamBusinessLogicImpl();
			errorMessageBean = new ErrorMessageBean();
			
			questionCategoryBeanList = new ArrayList<QuestionCategoryBean>();
					
			questionCategoryBeanList = examService.searchQCategory(searchQCategoryStr);			
			
			if(questionCategoryBeanList.size() > 0)
			{
				jsonString = examBusinessLogic.objectToJsonString(questionCategoryBeanList);
			}
			else
			{
				errorMessageBean.setMessage("Data Not Found");
				jsonString = examBusinessLogic.objectToJsonString(errorMessageBean);
			}		
			return jsonString;
		 }	
		
/*--------------------------------Search Question Sub Category for Add New Model--------------------------------------------------------*/
		
		@RequestMapping(value = "/searchQSubCategory", method = RequestMethod.POST, headers="Accept=application/json")  
		 public @ResponseBody String searchQSubCategory(@PathParam("qCategoryId") long qCategoryId)  
		 {  
			System.out.println("In searchQSubCategoryID :: "+qCategoryId);
			
			
			examBusinessLogic = new ExamBusinessLogicImpl();
			errorMessageBean = new ErrorMessageBean();
			
			questionSubCategoryBeanList = new ArrayList<QuestionSubCategoryBean>();
					
			questionSubCategoryBeanList = examService.searchQSubCategory(qCategoryId);			
			
			if(questionSubCategoryBeanList.size() > 0)
			{
				jsonString = examBusinessLogic.objectToJsonString(questionSubCategoryBeanList);
			}
			else
			{
				errorMessageBean.setMessage("Data Not Found");
				jsonString = examBusinessLogic.objectToJsonString(errorMessageBean);
			}		
			return jsonString;
		 }	
		
		
/*--------------------------------------Select Question for Add New Model-----------------------------------------------------------*/
		
		@RequestMapping(value = "/searchQuestionList", method = RequestMethod.POST, headers="Accept=application/json")  
		 public @ResponseBody String searchQuestionList(@PathParam("modelQuestionType") long modelQuestionType,
				 										@PathParam("qCategoryId") long qCategoryId,
				 										@PathParam("qSubCategoryId") long qSubCategoryId,
				 										@PathParam("showNoOfQuestion") long showNoOfQuestion)  
		 {  
			System.out.println("In modelQuestionType : "+modelQuestionType+" qCategoryId : "+qCategoryId+" qSubCategoryId : "+qSubCategoryId+" showNoOfQuestion : "+showNoOfQuestion);
			
			
			examBusinessLogic = new ExamBusinessLogicImpl();
			errorMessageBean = new ErrorMessageBean();	
			
			mcqBeanList = new ArrayList<McqBean>();
			descriptiveQBeanList = new ArrayList<DescriptiveQBean>();
			
			if(modelQuestionType == 1)
			{
				mcqBeanList = examService.searchMcqQuestionList(qCategoryId, qSubCategoryId, showNoOfQuestion);
				
				if(mcqBeanList.size() > 0)
				{
					jsonString = examBusinessLogic.objectToJsonString(mcqBeanList);
				}
				else
				{
					errorMessageBean.setMessage("Data Not Found");
					jsonString = examBusinessLogic.objectToJsonString(errorMessageBean);
				}	
			}
			else if(modelQuestionType == 2)
			{
				descriptiveQBeanList = examService.searchDescQuestionList(qCategoryId, qSubCategoryId, showNoOfQuestion);
				if(descriptiveQBeanList.size() > 0)
				{
					jsonString = examBusinessLogic.objectToJsonString(descriptiveQBeanList);
				}
				else
				{
					errorMessageBean.setMessage("Data Not Found");
					jsonString = examBusinessLogic.objectToJsonString(errorMessageBean);
				}					
			}
			else
				System.out.println("Question Type Does not match");					
			return jsonString;
		 }			

/*----------------------------------------------------Add New Model-----------------------------------------------------------*/
		
		@RequestMapping(value = "/addNewModel", method = RequestMethod.POST, headers="Accept=application/json")  
		 public @ResponseBody ModelAndView addNewModel(@ModelAttribute ("dataString") QuestionModelBean questionModelBean, BindingResult result)  
		 {  
			System.out.println(questionModelBean);
			
			
			
			questionModelBean = examService.addNewModel(questionModelBean);		
			
			return new ModelAndView("addModelQuestion","message","Model Question Successfull Created");
		 }			
		
/*--------------------------------------------------Show All Model Question Set------------------------------------------------------------------*/
		
		@RequestMapping(value = "/showModelQSet", method = RequestMethod.GET, headers="Accept=application/json")  
		 public @ResponseBody ModelAndView showModelQSet()  
		 {  			
			questionModelBeanList = new ArrayList<QuestionModelBean>();			
			
			
			questionModelBeanList = examService.showModelQSet();
			
			return new ModelAndView("showModelQSet", "questionModelBeanList", questionModelBeanList);
		 }	
		
		
/*========================================================= SEND IN JSP PAGE =============================================================================*/	
	
/*----------------------------------------------------Send MCQ Question Page----------------------------------------------------------------------*/
	
	@RequestMapping(value = "/openMcqQuestionPage", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView openMcqQuestionPage()  
	 {  
		System.out.println("In addMcqQuestion");		
		return new ModelAndView("addMcqQuestion");
	 }
	
/*----------------------------------------------------Send showAllMcqQuestions Question Page-------------------------------------------------------*/
	
	@RequestMapping(value = "/showAllMcqQuestionsPage", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView showAllMcqQuestionsPage()  
	 {  
		System.out.println("In addMcqQuestion");		
		return new ModelAndView("showAllMcqQuestions");
	 }
	
/*----------------------------------------------Send Descriptive Question Page---------------------------------------------------------------------*/	
	
	@RequestMapping(value = "/openDescQuestionPage", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView openDescQuestionPage()  
	 {  
		System.out.println("In addDescQuestion");		
		return new ModelAndView("addDescQuestion");
	 }	
	
/*----------------------------------------------Open Add Categories Page---------------------------------------------------------------------*/	
	
	@RequestMapping(value = "/openAddQCategoryPage", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView openAddQCategoryPage()  
	 {  
		System.out.println("In openAddQCategoryPage");		
		return new ModelAndView("addQCategory");
	 }
	
/*----------------------------------------------Open Add Categories Page---------------------------------------------------------------------*/	
	
	@RequestMapping(value = "/addModelQuestionPage", method = RequestMethod.GET, headers="Accept=application/json")  
	 public @ResponseBody ModelAndView addQuestionModel()  
	 {  
		System.out.println("In Question Model");		
		return new ModelAndView("addModelQuestion");
	 }
	
	
	
}
