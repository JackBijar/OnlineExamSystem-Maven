package com.mayabious.examsystem.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mayabious.examsystem.bean.DescriptiveQBean;
import com.mayabious.examsystem.bean.ExamReportBean;
import com.mayabious.examsystem.bean.McqBean;
import com.mayabious.examsystem.bean.QuestionCategoryBean;
import com.mayabious.examsystem.bean.QuestionModelBean;
import com.mayabious.examsystem.bean.QuestionSubCategoryBean;
import com.mayabious.examsystem.dao.CandidateDao;
import com.mayabious.examsystem.dao.ExamDao;
import com.mayabious.examsystem.dao.ExamDaoImpl;

@Service
@Transactional
public class ExamServiceImpl implements ExamService 
{
	@Autowired
	private ExamDao examDao;
	
	public McqBean addMcqQuestion(McqBean mcqBean) 
	{		
		
		return examDao.addMcqQuestion(mcqBean);
	}

	
	public DescriptiveQBean addDescQuestion(DescriptiveQBean descriptiveQBean) 
	{
		
		return examDao.addDescQuestion(descriptiveQBean);
	}

	
	public List<McqBean> showAllMcq() 
	{		
		
		return examDao.showAllMcq();
	}

	
	public List<DescriptiveQBean> showAllDescQuestion() 
	{
		
		return examDao.showAllDescQuestion();
	}

	
	public int deleteMcqQuestion(long mcqId) 
	{
		
		return examDao.deleteMcqQuestion(mcqId);
	}
	
	
	public ExamReportBean saveCandidateMcqAns(Map<Long, Long> mcqResultMap, long cId) 
	{
		
		return examDao.saveCandidateMcqAns(mcqResultMap, cId);
	}

	
	public int deleteDescQuestion(long dQuestionId) 
	{
		
		return examDao.deleteDescQuestion(dQuestionId);
	}	

	
	public ExamReportBean saveCandidateDescAns(Map<Long, String> descResultmap, long cId) 
	{
		
		return examDao.saveCandidateDescAns(descResultmap, cId);
	}

	
	public List<ExamReportBean> fetchDescUncheckCandidate() 
	{
		
		return examDao.fetchDescUncheckCandidate();
	}

	
	public List<DescriptiveQBean> checkDescAns(long reportId) 
	{
		
		return examDao.checkDescAns(reportId);
	}

	
	public List<ExamReportBean> viewCandidateReport() 
	{
		
		return examDao.viewCandidateReport();
	}

	
	public List<McqBean> getCandidateMcqReport(long cId) 
	{
		
		return examDao.getCandidateMcqReport(cId);
	}

	
	public McqBean updateMcqQuestion(McqBean mcqBean) 
	{
		
		return examDao.updateMcqQuestion(mcqBean);
	}

	
	public DescriptiveQBean updateDescQuestion(DescriptiveQBean descriptiveQBean) 
	{
		
		return examDao.updateDescQuestion(descriptiveQBean);
	}

	
	public List<ExamReportBean> saveDescMarks(long reportId, Map<Long, Long> descSaveMarksMap) 
	{
		
		return examDao.saveDescMarks(reportId, descSaveMarksMap);
	}

	
	public int checkMcqExamStatus(Long cId) 
	{		
		
		return examDao.checkMcqExamStatus(cId);
	}

	
	public int checkDescExamStatus(long cId) 
	{
		
		return examDao.checkDescExamStatus(cId);
	}

	
	public QuestionCategoryBean addQCategory(QuestionCategoryBean questionCategoryBean)
	{
		
		return examDao.addQCategory(questionCategoryBean);
	}

	
	public List<QuestionCategoryBean> showQCategory() 
	{
		
		return examDao.showQCategory();
	}

	
	public int deleteQCategory(long qCategoryId) 
	{
		
		return examDao.deleteQCategory(qCategoryId);
	}

	
	public QuestionCategoryBean updateQCategory(QuestionCategoryBean questionCategoryBean) 
	{
		
		return examDao.updateQCategory(questionCategoryBean);
	}

	
	public List<QuestionCategoryBean> searchQCategory(String searchQCategoryStr) 
	{
		
		return examDao.searchQCategory(searchQCategoryStr);
	}

	
	public List<QuestionSubCategoryBean> searchQSubCategory(long qCategoryId) 
	{
		
		return examDao.searchQSubCategory(qCategoryId);
	}

	
	public QuestionModelBean addNewModel(QuestionModelBean questionModelBean) 
	{
		
		return examDao.addNewModel(questionModelBean);
	}

	
	public List<McqBean> searchMcqQuestionList(long qCategoryId, long qSubCategoryId, long showNoOfQuestion) 
	{
		
		return examDao.searchMcqQuestionList(qCategoryId, qSubCategoryId, showNoOfQuestion);
	}

	
	public List<DescriptiveQBean> searchDescQuestionList(long qCategoryId, long qSubCategoryId, long showNoOfQuestion) 
	{
		
		return examDao.searchDescQuestionList(qCategoryId, qSubCategoryId, showNoOfQuestion);
	}

	
	public List<QuestionModelBean> showModelQSet() 
	{
		return examDao.showModelQSet();
	}

}
