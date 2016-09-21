package com.mayabious.examsystem.service;

import java.util.List;
import java.util.Map;

import com.mayabious.examsystem.bean.DescriptiveQBean;
import com.mayabious.examsystem.bean.ExamReportBean;
import com.mayabious.examsystem.bean.McqBean;
import com.mayabious.examsystem.bean.QuestionCategoryBean;
import com.mayabious.examsystem.bean.QuestionModelBean;
import com.mayabious.examsystem.bean.QuestionSubCategoryBean;

public interface ExamService 
{
	public McqBean addMcqQuestion(McqBean mcqBean);
	
	public List<McqBean> showAllMcq();
	
	public McqBean updateMcqQuestion(McqBean mcqBean);
	
	public int deleteMcqQuestion(long mcqId);
	
	
	public int checkMcqExamStatus(Long cId);	// Take Mcq Exam 1 Time
	
	public ExamReportBean saveCandidateMcqAns(Map<Long, Long> mcqResultMap, long cId);
	
	public List<McqBean> getCandidateMcqReport(long cId);
	
	
	public DescriptiveQBean addDescQuestion(DescriptiveQBean descriptiveQBean);	
	
	public List<DescriptiveQBean> showAllDescQuestion();
	
	public DescriptiveQBean updateDescQuestion(DescriptiveQBean descriptiveQBean);
	
	public int deleteDescQuestion(long dQuestionId);
	
	
	public int checkDescExamStatus(long cId);	// Take Desc Exam 1 Time
	
	public ExamReportBean saveCandidateDescAns(Map<Long, String> descResultmap, long cId);			/*---Candidate---*/
	
	
	public List<ExamReportBean> fetchDescUncheckCandidate();										/*---Admin---*/
	
	public List<DescriptiveQBean> checkDescAns(long reportId);										/*---Admin---*/
	
	public List<ExamReportBean> saveDescMarks(long reportId, Map<Long, Long> descSaveMarksMap);		/*---Admin---*/
	
	
	public List<ExamReportBean> viewCandidateReport();	
	
	
/*-------------------------------Question Category------------------------------------------------------------*/
	
	public QuestionCategoryBean addQCategory(QuestionCategoryBean questionCategoryBean);
	
	public List<QuestionCategoryBean> showQCategory();
	
	public int deleteQCategory(long qCategoryId);
	
	public QuestionCategoryBean updateQCategory(QuestionCategoryBean questionCategoryBean);
	
/*-------------------------------Add New Question Model Section------------------------------------------------------------*/	
	
	public List<QuestionCategoryBean> searchQCategory(String searchQCategoryStr);
	
	public List<QuestionSubCategoryBean> searchQSubCategory(long qCategoryId);	
	
	public List<McqBean> searchMcqQuestionList(long qCategoryId, long qSubCategoryId, long showNoOfQuestion);
	
	public List<DescriptiveQBean> searchDescQuestionList(long qCategoryId, long qSubCategoryId, long showNoOfQuestion);
	
	public QuestionModelBean addNewModel(QuestionModelBean questionModelBean);
	
	public List<QuestionModelBean> showModelQSet();
	
}
