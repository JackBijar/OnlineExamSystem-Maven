package com.mayabious.examsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.mayabious.examsystem.bean.DescriptiveQBean;
import com.mayabious.examsystem.bean.ExamReportBean;
import com.mayabious.examsystem.bean.McqBean;
import com.mayabious.examsystem.bean.QuestionCategoryBean;
import com.mayabious.examsystem.bean.QuestionModelBean;
import com.mayabious.examsystem.bean.QuestionSubCategoryBean;
import com.mayabious.examsystem.util.CandidateDaoUtil;
import com.mayabious.examsystem.util.ExamDaoUtil;

public class ExamDaoImpl implements ExamDao 
{
	@Autowired
	private ExamDaoUtil examDaoUtil;
	
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	int status = 0;
	int result = 0;
	
	McqBean mcqBean = null;
	DescriptiveQBean descriptiveQBean = null;
	ExamReportBean examReportBean = null ;
	QuestionCategoryBean questionCategoryBean = null;
	QuestionSubCategoryBean questionSubCategoryBean = null;
	QuestionModelBean questionModelBean = null;
	
	
	List<McqBean> mcqBeanList = null;
	List<DescriptiveQBean> descBeanList = null;
	List<ExamReportBean> examReportBeanList = null;
	List<DescriptiveQBean>	descriptiveQBeanList = null;
	List<QuestionCategoryBean> questionCategoryBeanList = null;
	List<QuestionSubCategoryBean>  questionSubCategoryBeanList = null;
	List<QuestionModelBean> questionModelBeanList = null;

/*=================================================== Add MCQ Questions ==========================================================*/
	
	
	public McqBean addMcqQuestion(McqBean mcqBean) 
	{		
		if(mcqBean.getMcqCorrectId() == 1)
			mcqBean.setMcqCorrectAns(mcqBean.getMcqAns1());
		else if(mcqBean.getMcqCorrectId() == 2)
			mcqBean.setMcqCorrectAns(mcqBean.getMcqAns2());
		else if(mcqBean.getMcqCorrectId() == 3)
			mcqBean.setMcqCorrectAns(mcqBean.getMcqAns3());
		else
			mcqBean.setMcqCorrectAns(mcqBean.getMcqAns4());
			
		try
		{
			con = DBConnectionFactory.getConnection();
			
			pst = con.prepareStatement("insert into mcq_question_info"
										+ "(mcq_question, mcq_ans_1, mcq_ans_2, mcq_ans_3, mcq_ans_4, mcq_correct_ans, "
										+ "mcq_correct_id, mcq_ans_description, q_category_id, q_sub_category_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			pst.setString(1, mcqBean.getMcqQuestion());
			pst.setString(2, mcqBean.getMcqAns1());
			pst.setString(3, mcqBean.getMcqAns2());
			pst.setString(4, mcqBean.getMcqAns3());
			pst.setString(5, mcqBean.getMcqAns4());
			pst.setString(6, mcqBean.getMcqCorrectAns());
			pst.setLong(7, mcqBean.getMcqCorrectId());
			pst.setString(8, mcqBean.getMcqAnsDescription());
			pst.setLong(9, mcqBean.getqCategoryId());
			pst.setLong(10, mcqBean.getqSubCategoryId());
			
			result = pst.executeUpdate();
			if(result > 0)
			{
				pst = con.prepareStatement("select max(mcq_id) from mcq_question_info");
				rs = pst.executeQuery();				
				while(rs.next())
				{
					System.out.println("MAX ID : "+rs.getLong(1));
					mcqBean.setMcqId(rs.getLong(1));
				}
			}
			else
				System.out.println("Not Successfully Saved");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return mcqBean;
	}

/*=================================================== Add Descriptive Questions ====================================================*/
	
	
	public DescriptiveQBean addDescQuestion(DescriptiveQBean descriptiveQBean) 
	{		
		try
		{
			con = DBConnectionFactory.getConnection();
			
			pst = con.prepareStatement("insert into descriptive_question_info(d_question, d_question_ans, d_question_marks, q_category_id, q_sub_category_id)"
										+ "values(?, ?, ?, ?, ?)");
			
			pst.setString(1, descriptiveQBean.getdQuestion());
			pst.setString(2, descriptiveQBean.getdQuestionAns());
			pst.setLong(3, descriptiveQBean.getdQuestionMarks());
			pst.setLong(4, descriptiveQBean.getqCategoryId());
			pst.setLong(5, descriptiveQBean.getqSubCategoryId());
			
			status = pst.executeUpdate();
			if(status > 0)
			{
				pst = con.prepareStatement("select max(d_question_id) from descriptive_question_info");
				rs = pst.executeQuery();				
				while(rs.next())
				{
					System.out.println("MAX ID : "+rs.getLong(1));
					descriptiveQBean.setdQuestionId(rs.getLong(1));
				}
			}
			else
				System.out.println("Not Successfully Saved");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return descriptiveQBean;
		
	}

/*=================================================== Show All MCQ ================================================================*/
	
	
	public List<McqBean> showAllMcq()
	{
		mcqBeanList = new ArrayList<McqBean>();		
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("select * from mcq_question_info");//limit 5
			
			rs = pst.executeQuery();
			while(rs.next())
			{
				mcqBean = new McqBean();				
				mcqBean.setMcqId(rs.getLong("mcq_id"));
				mcqBean.setMcqQuestion(rs.getString("mcq_question"));
				mcqBean.setMcqAns1(rs.getString("mcq_ans_1"));
				mcqBean.setMcqAns2(rs.getString("mcq_ans_2"));
				mcqBean.setMcqAns3(rs.getString("mcq_ans_3"));
				mcqBean.setMcqAns4(rs.getString("mcq_ans_4"));
				mcqBean.setMcqCorrectAns(rs.getString("mcq_correct_ans"));
				mcqBean.setMcqCorrectId(rs.getLong("mcq_correct_id"));
				mcqBean.setMcqAnsDescription(rs.getString("mcq_ans_description"));
				mcqBean.setqCategoryId(rs.getLong("q_category_id"));
				mcqBean.setqSubCategoryId(rs.getLong("q_sub_category_id"));
				mcqBeanList.add(mcqBean);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return mcqBeanList;
	}

/*=================================================== Show All Descriptive =========================================================*/
	
	
	public List<DescriptiveQBean> showAllDescQuestion() 
	{
		descBeanList = new ArrayList<DescriptiveQBean>();		
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("select * from descriptive_question_info ");//limit 2
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				descriptiveQBean = new DescriptiveQBean();
				descriptiveQBean.setdQuestionId(rs.getLong("d_question_id"));
				descriptiveQBean.setdQuestion(rs.getString("d_question"));
				descriptiveQBean.setdQuestionAns(rs.getString("d_question_ans"));
				descriptiveQBean.setdQuestionMarks(rs.getLong("d_question_marks"));
				descriptiveQBean.setqCategoryId(rs.getLong("q_category_id"));
				descriptiveQBean.setqSubCategoryId(rs.getLong("q_sub_category_id"));
				descBeanList.add(descriptiveQBean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return descBeanList;
	}

/*=================================================== Delete MCQ Questions =========================================================*/	
	
	
	public int deleteMcqQuestion(long mcqId) 
	{		
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("delete from mcq_question_info where mcq_id = ?");
			pst.setLong(1, mcqId);
			
			result = pst.executeUpdate();
			
			if(result > 0)
			{
				status = 1;
				System.out.println("Delete Successfully");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = 0;
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return status;
	}

/*============================================== Save Candidate Ans into mcq_result Table ==================================*/	
	
	
	public ExamReportBean saveCandidateMcqAns(Map<Long, Long> mcqResultMap, long cId) 
	{		
		long reportId = 0;
		int result_1 = 0;	
		int result_2 = 0;
		int correctAns = 0;
		int cScore = 0;
		int finalScore = 0;
		examReportBean = new ExamReportBean();
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("select max(report_id) from candidate_report where c_id = ?");	/*===Fetch Max Report ID respect to Candidate====*/
			pst.setLong(1, cId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				reportId = rs.getLong(1);
				System.out.println("ReportId : "+reportId);
			}								
			
			System.out.println("SIZE : "+mcqResultMap.size());
			
			for ( Map.Entry<Long, Long> entry : mcqResultMap.entrySet()) 
			{		    
				pst = con.prepareStatement("select mcq_correct_id from mcq_question_info where mcq_id = ?");	//Find Correct Ans ID from mcq_question_info 
				pst.setLong(1, entry.getKey());	
				rs = pst.executeQuery();
				
				if(rs.next())
				{
					correctAns = rs.getInt("mcq_correct_id");		// Correct Ans ID
				}
				
				if(correctAns == entry.getValue())			//Matching Correct Ans ID
				{
					cScore = 1;
					finalScore++;									//Increment currect result
				}
				else
				{
					cScore = 0;
				}				
				pst = con.prepareStatement("insert into mcq_result(report_id, mcq_id, c_ans_id, c_score) values(?, ?, ?, ?)");				
				pst.setLong(1, reportId);
				pst.setLong(2, entry.getKey());
				pst.setLong(3, entry.getValue());
				pst.setInt(4, cScore);
				result_1 = pst.executeUpdate();
			}
			if(result_1 > 0)	
			{	
				System.out.println("Mcq Result Successfully Inserted in Mcq Result");			
				pst = con.prepareStatement("update candidate_report set mcq_result = ?, mcq_report_status = ? where report_id = ?;");
				pst.setInt(1,finalScore);
				pst.setInt(2, 1);
				pst.setLong(3, reportId);
				result_2 = pst.executeUpdate();
				if(result_2 > 0)
				{
					System.out.println("Mcq Result Successfully Updated in Candidate Report");
					examReportBean.setReportId(reportId);
					examReportBean.setMcqResult(finalScore);	
				}
				else
				{
					System.out.println("Mcq Result NOT** Updated in Candidate Report");
				}
			}
			else
			{
				System.out.println("Mcq Result NOT** Inserted in Mcq Result");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = 0;
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return examReportBean;
	}
	
/*=================================================== Delete MCQ Questions =========================================================*/
	
	
	public int deleteDescQuestion(long dQuestionId) 
	{		
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("delete from descriptive_question_info where d_question_id = ?");
			pst.setLong(1, dQuestionId);
			
			result = pst.executeUpdate();
			
			if(result > 0)
			{
				status = 1;
				System.out.println("Delete Successfully");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = 0;
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return status;
	}
	
/*======================================================= Save Desc Exam Result===================================================*/	
	
	
	public ExamReportBean saveCandidateDescAns(Map<Long, String> descResultmap, long cId) 
	{
		long reportId = 0;
		examReportBean = new ExamReportBean();
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("select max(report_id) from candidate_report where c_id = ?");	/*===Fetch Max Report ID respect to Candidate====*/
			pst.setLong(1, cId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				reportId = rs.getLong(1);
				System.out.println("ReportId : "+reportId);
			}								
			
			System.out.println("SIZE : "+descResultmap.size());
			
			for ( Map.Entry<Long, String> entry : descResultmap.entrySet()) 
			{				
				pst = con.prepareStatement("insert into descriptive_result(report_id, d_question_id, c_given_ans, given_marks) values(?, ?, ?, ?)");				
				pst.setLong(1, reportId);
				pst.setLong(2, entry.getKey());
				pst.setString(3, entry.getValue());
				pst.setInt(4, 0);
				result = pst.executeUpdate();
			}
			if(result > 0)
			{
				pst = con.prepareStatement("update candidate_report set desc_report_status = ? where report_id = ?");
				pst.setInt(1, 1);
				pst.setLong(2, reportId);
				int reportStatus = pst.executeUpdate();
				if(reportStatus > 0)
				{
					System.out.println("Successfully set desc_report_status = 1 in Candidate Report ");
				}				
				pst = con.prepareStatement("Select mcq_result from candidate_report where report_id = ?");
				pst.setLong(1, reportId);
				rs = pst.executeQuery();
				if(rs.next())
				{
					examReportBean.setMcqResult(rs.getLong("mcq_result"));
					examReportBean.setReportId(reportId);
				}
				else
					System.out.println("MCQ Result Not Found");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = 0;
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return examReportBean;
	}

/*=================================================== Get Unchecked Candidate Desc Result=========================================*/	
	
	
	public List<ExamReportBean> fetchDescUncheckCandidate() 
	{
		examReportBeanList = new ArrayList<ExamReportBean>();		
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("select report_id, c_id, mcq_result from candidate_report where desc_report_status = ? and check_desc_report_status = ?");	/*===Fetch Max Report ID respect to Candidate====*/
			pst.setInt(1, 1);
			pst.setInt(2, 0);
			rs=pst.executeQuery();
			while(rs.next())
			{
				examReportBean = new ExamReportBean();
				examReportBean.setReportId(rs.getLong("report_id"));
				examReportBean.setcId(rs.getLong("c_id"));
				examReportBean.setMcqResult(rs.getInt("mcq_result"));
				examReportBeanList.add(examReportBean);
			}	
			System.out.println("Size Of List "+examReportBeanList.size());			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = 0;
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return examReportBeanList;
	}

/*=======================================================Check descriptive Question===================================================*/	
	
	
	public List<DescriptiveQBean> checkDescAns(long reportId) 
	{
		descriptiveQBeanList = new ArrayList<DescriptiveQBean>();		
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("select * from descriptive_result where report_id = ?");	/*===Fetch all data by Report ID ====*/
			pst.setLong(1, reportId);
			rs=pst.executeQuery();
			while(rs.next())
			{
				descriptiveQBean = new DescriptiveQBean();
				descriptiveQBean.setReportId(rs.getLong("report_id"));
				descriptiveQBean.setdQuestionId(rs.getLong("d_question_id"));
				descriptiveQBean.setGivenMarks(rs.getLong("given_marks"));
				descriptiveQBean.setcGivenAns(rs.getString("c_given_ans"));
				descriptiveQBeanList.add(descriptiveQBean);
			}	
			
			for(DescriptiveQBean descriptiveQBean : descriptiveQBeanList)
			{
				pst = con.prepareStatement("select * from descriptive_question_info where d_question_id = ?");
				pst.setLong(1, descriptiveQBean.getdQuestionId());
				rs=pst.executeQuery();
				if(rs.next())
				{
					descriptiveQBean.setdQuestion(rs.getString("d_question"));
					descriptiveQBean.setdQuestionAns(rs.getString("d_question_ans"));
					descriptiveQBean.setdQuestionMarks(rs.getLong("d_question_marks"));
				}
			}				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = 0;
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}		
		return descriptiveQBeanList;
	}
	
/*================================================View Candidate Complete Exam Report=============================================*/	

	
	public List<ExamReportBean> viewCandidateReport() 
	{
		examReportBeanList = new ArrayList<ExamReportBean>();		
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("select * from candidate_report where mcq_report_status = ? and check_desc_report_status = ?  order by report_id");	/*===Fetch all data by Report ID ====*/
			pst.setInt(1, 1);
			pst.setInt(2, 1);
			rs = pst.executeQuery();
			while(rs.next())
			{
				examReportBean = new ExamReportBean();
				examReportBean.setReportId(rs.getLong("report_id"));
				examReportBean.setcId(rs.getLong("c_id"));
				examReportBean.setMcqResult(rs.getLong("mcq_result"));
				examReportBean.setDescResult(rs.getLong("desc_result"));
				examReportBean.setTotal(rs.getLong("total"));
				examReportBean.setGrade(rs.getString("grade"));
				examReportBeanList.add(examReportBean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = 0;
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}		
		return examReportBeanList;
	}

/*================================================== Mcq Report Check by Candidate =============================================*/
	
	
	public List<McqBean> getCandidateMcqReport(long cId) 
	{		
		long reportId = 0;
		List<McqBean> mcqBeanList = new ArrayList<McqBean>();
		
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("select max(report_id) from candidate_report where c_id = ?");	/*===Fetch Max Report ID respect to Candidate====*/
			pst.setLong(1, cId);
			rs=pst.executeQuery();
			if(rs.next())
			{
				reportId = rs.getLong(1);
				System.out.println("ReportId : "+reportId);
			}								
			pst = con.prepareStatement("select * from mcq_result where report_id = ?");
			pst.setLong(1, reportId);
			rs = pst.executeQuery();
			while(rs.next())
			{
				mcqBean = new McqBean();
				mcqBean.setMcqId(rs.getLong("mcq_id"));
				mcqBean.setcGivenAnsId(rs.getLong("c_ans_id"));
				pst = con.prepareStatement("select * from mcq_question_info where mcq_id = ?");
				pst.setLong(1, rs.getLong("mcq_id"));
				
				ResultSet rs1 = pst.executeQuery();				
				if(rs1.next())
				{
					mcqBean.setMcqQuestion(rs1.getString("mcq_question"));
					mcqBean.setMcqAns1(rs1.getString("mcq_ans_1"));
					mcqBean.setMcqAns2(rs1.getString("mcq_ans_2"));
					mcqBean.setMcqAns3(rs1.getString("mcq_ans_3"));
					mcqBean.setMcqAns4(rs1.getString("mcq_ans_4"));
					mcqBean.setMcqCorrectAns(rs1.getString("mcq_correct_ans"));
					mcqBean.setMcqCorrectId(rs1.getInt("mcq_correct_id"));
					mcqBean.setMcqAnsDescription(rs1.getString("mcq_ans_description"));
					mcqBeanList.add(mcqBean);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = 0;
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return mcqBeanList;
	}

/*================================================== Update Mcq Question ======================================================*/	
	
	
	public McqBean updateMcqQuestion(McqBean mcqBean) 
	{
		try
		{
			con = DBConnectionFactory.getConnection();
			pst = con.prepareStatement("update mcq_question_info set mcq_question = ?, mcq_ans_1 = ?, mcq_ans_2 = ?, mcq_ans_3 = ?, "
										+ "mcq_ans_4 = ?, mcq_correct_ans = ?, mcq_correct_id = ?, mcq_ans_description = ?, q_category_id = ?, q_sub_category_id = ? where mcq_id = ? ");
			
			pst.setString(1, mcqBean.getMcqQuestion());
			pst.setString(2, mcqBean.getMcqAns1());
			pst.setString(3, mcqBean.getMcqAns2());
			pst.setString(4, mcqBean.getMcqAns3());
			pst.setString(5, mcqBean.getMcqAns4());
			pst.setString(6, mcqBean.getMcqCorrectAns());
			pst.setLong(7, mcqBean.getMcqCorrectId());			
			pst.setString(8, mcqBean.getMcqAnsDescription());
			pst.setLong(9, mcqBean.getqCategoryId());
			pst.setLong(10, mcqBean.getqSubCategoryId());
			pst.setLong(11, mcqBean.getMcqId());
			result = pst.executeUpdate();
			if(result > 0)
			{
				System.out.println("Successfully Updated");
			}
			else
				System.out.println("Not Successfully Saved");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return mcqBean;
	}

/*================================================== Update Descriptive Question ===============================================*/	
	
	
	public DescriptiveQBean updateDescQuestion(DescriptiveQBean descriptiveQBean) 
	{		
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("update descriptive_question_info set d_question = ?, d_question_ans = ?, "
											+ "d_question_marks = ?, q_category_id = ?, q_sub_category_id = ? where d_question_id = ?");			
			pst.setString(1, descriptiveQBean.getdQuestion());
			pst.setString(2, descriptiveQBean.getdQuestionAns());
			pst.setLong(3, descriptiveQBean.getdQuestionMarks());
			pst.setLong(4, descriptiveQBean.getqCategoryId());
			pst.setLong(5, descriptiveQBean.getqSubCategoryId());
			pst.setLong(6, descriptiveQBean.getdQuestionId());			
			
			status = pst.executeUpdate();
			if(status > 0)
			{
				System.out.println("Successfull Updated");
			}
			else
				System.out.println("Not Successfully Saved");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return descriptiveQBean;		
	}

/*===================================================== Save Descriptive Marks =============================================*/	
	
	
	public List<ExamReportBean> saveDescMarks(long reportId, Map<Long, Long> descSaveMarksMap) 
	{		
		examReportBeanList = new ArrayList<ExamReportBean>();
		long descResult = 0;
		try
		{
			con = DBConnectionFactory.getConnection();				
			for ( Map.Entry<Long, Long> entry : descSaveMarksMap.entrySet()) 
			{				
				pst = con.prepareStatement("update descriptive_result set given_marks = ? where d_question_id = ? and report_id = ?");
				pst.setLong(1, entry.getValue());
				pst.setLong(2, entry.getKey());
				pst.setLong(3, reportId);
				
				descResult += entry.getValue();
				System.out.println("Desc Result : "+descResult);
			}	
			status = pst.executeUpdate();
			if(status > 0)
			{				
				System.out.println("Save Successfull");				
				pst = con.prepareStatement("update candidate_report set desc_result = ?, check_desc_report_status = ? where report_id = ?");				
				pst.setLong(1, descResult);
				pst.setLong(2, 1);
				pst.setLong(3, reportId);
				result = pst.executeUpdate();
				if(result > 0)
				{
					System.out.println("Successfull Update check_desc_report_status = 1 in candidate_report table");
					pst = con.prepareStatement("select * from candidate_report where desc_report_status = ? and check_desc_report_status = ?");	/*===Fetch Max Report ID respect to Candidate====*/
					pst.setInt(1, 1);
					pst.setInt(2, 0);
					rs=pst.executeQuery();
					while(rs.next())
					{						
						examReportBean = new ExamReportBean();
						examReportBean.setReportId(rs.getLong("report_id"));
						examReportBean.setcId(rs.getLong("c_id"));
						examReportBean.setMcqResult(rs.getInt("mcq_result"));
						System.out.println(rs.getLong("c_id")+"==="+rs.getLong("report_id")+"==="+rs.getInt("mcq_result"));
						examReportBeanList.add(examReportBean);
					}
				}
				else
					System.out.println("Not Successfull Update desc_report_status = 1 in candidate_report table");
			}
			else
				System.out.println("Not Successfully Saved");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return examReportBeanList;
	}
	
/*===================================================== Check mcq_report_status =============================================*/
	
	
	public int checkMcqExamStatus(Long cId) 
	{
		try
		{
			con = DBConnectionFactory.getConnection();	
			pst = con.prepareStatement("select mcq_report_status from candidate_report where report_id in "
											+ "(select max(report_id) from candidate_report where c_id = ?)");
			pst.setLong(1, cId);
			rs = pst.executeQuery();
			if(rs.next())
			{
				System.out.println("REPORT STATUS = "+rs.getInt("mcq_report_status"));
				if(rs.getInt("mcq_report_status") == 1)
				{
					System.out.println("MCQ Exam Already Done");
					status = 0;
				}
				else if(rs.getInt("mcq_report_status") == 0)
				{
					System.out.println("Take this Aptitude Test 1'st time");
					status = 1;
				}
				else
					System.out.println("Some Other Problem in mcq_report_status");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return status;
	}

/*===================================================== Check desc_report_status =============================================*/
	
	
	public int checkDescExamStatus(long cId) 
	{
		try
		{
			con = DBConnectionFactory.getConnection();	
			pst = con.prepareStatement("select desc_report_status from candidate_report where report_id in "
											+ "(select max(report_id) from candidate_report where c_id = ?)");
			pst.setLong(1, cId);
			rs = pst.executeQuery();
			if(rs.next())
			{
				System.out.println("REPORT STATUS = "+rs.getInt("desc_report_status"));
				if(rs.getInt("desc_report_status") == 1)
				{
					System.out.println("Desc Exam Already Done");
					status = 0;
				}
				else if(rs.getInt("desc_report_status") == 0)
				{
					System.out.println("Take this Desc Test 1'st time");
					status = 1;
				}
				else
					System.out.println("Some Other Problem in desc_report_status");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return status;
	}

	
/*===================================================== Add Question Category =============================================*/	
	
	
	public QuestionCategoryBean addQCategory(QuestionCategoryBean questionCategoryBean) 
	{
		try
		{
			con = DBConnectionFactory.getConnection();
			
			pst = con.prepareStatement("insert into question_category(q_category_name, q_category_description) values(?, ?)");
			
			pst.setString(1, questionCategoryBean.getqCategoryName());
			pst.setString(2, questionCategoryBean.getqCategoryDescription());
			
			result = pst.executeUpdate();
			if(result > 0)
			{
				pst = con.prepareStatement("select max(q_category_id) from question_category");
				rs = pst.executeQuery();				
				while(rs.next())
				{
					System.out.println("MAX q_category_id ID : "+rs.getLong(1));
					questionCategoryBean.setqCategoryId(rs.getLong(1));
				}
			}
			else
				System.out.println("Not Successfully Saved");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return questionCategoryBean;
	}

/*===================================================== Show Question Category =============================================*/		
	
	
	public List<QuestionCategoryBean> showQCategory() 
	{
		questionCategoryBeanList = new ArrayList<QuestionCategoryBean>();		
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("select * from question_category");
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				questionCategoryBean = new QuestionCategoryBean();
				questionCategoryBean.setqCategoryId(rs.getLong("q_category_id"));
				questionCategoryBean.setqCategoryName(rs.getString("q_category_name"));
				questionCategoryBean.setqCategoryDescription(rs.getString("q_category_description"));
				questionCategoryBeanList.add(questionCategoryBean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return questionCategoryBeanList;
	}

/*===================================================== Show Question Category =============================================*/		
	
	
	public int deleteQCategory(long qCategoryId) 
	{
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("delete from question_category where q_category_id = ?");
			pst.setLong(1, qCategoryId);
			result = pst.executeUpdate();		
			if(result > 0)
			{
				System.out.println("Successfully Deleted "+qCategoryId);
				status = 1;
			}
			else
				System.out.println("Not Successfully Deleted "+qCategoryId);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}		
		return status;
	}

/*===================================================== Show Question Category ================================================*/
	
	
	public QuestionCategoryBean updateQCategory(QuestionCategoryBean questionCategoryBean) 
	{
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("update question_category set q_category_name = ?, q_category_description = ? where q_category_id = ?");			
			pst.setString(1, questionCategoryBean.getqCategoryName());
			pst.setString(2, questionCategoryBean.getqCategoryDescription());
			pst.setLong(3, questionCategoryBean.getqCategoryId());			
			
			status = pst.executeUpdate();
			if(status > 0)
			{
				System.out.println("Successfull Updated");
			}
			else
				System.out.println("Not Successfully Saved");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return questionCategoryBean;	
	}

/*===================================================== Search Question Category ================================================*/
	
	
	public List<QuestionCategoryBean> searchQCategory(String searchQCategoryStr) 
	{
		List<QuestionCategoryBean> questionCategoryBeanList = new ArrayList<QuestionCategoryBean>();
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("select * from question_category where q_category_name like ? ");
			pst.setString(1, "%"+searchQCategoryStr+"%");
			rs = pst.executeQuery();
			while(rs.next())
			{
				questionCategoryBean = new QuestionCategoryBean();
				questionCategoryBean.setqCategoryId(rs.getLong("q_category_id"));
				questionCategoryBean.setqCategoryName(rs.getString("q_category_name"));
				questionCategoryBean.setqCategoryDescription(rs.getString("q_category_description"));
				questionCategoryBeanList.add(questionCategoryBean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return questionCategoryBeanList;		
	}

/*===================================================== Search Question Sub Category ================================================*/
	
	
	public List<QuestionSubCategoryBean> searchQSubCategory(long qCategoryId) 
	{
		questionSubCategoryBeanList = new ArrayList<QuestionSubCategoryBean>();		
		try
		{
			con = DBConnectionFactory.getConnection();		
			pst = con.prepareStatement("select * from question_sub_category where q_category_id = ? ");
			pst.setLong(1, qCategoryId);
			rs = pst.executeQuery();
			while(rs.next())
			{
				questionSubCategoryBean = new QuestionSubCategoryBean();				
				questionSubCategoryBean.setqSubCategoryId(rs.getLong("q_sub_category_id"));
				questionSubCategoryBean.setqSubCategoryName(rs.getString("q_sub_category_name"));
				questionSubCategoryBean.setqCategoryId(rs.getLong("q_category_id"));	
				questionSubCategoryBeanList.add(questionSubCategoryBean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return questionSubCategoryBeanList;		
	}

/*===================================================== Search MCQ for Model ================================================*/	

	
	public List<McqBean> searchMcqQuestionList(long qCategoryId, long qSubCategoryId, long showNoOfQuestion) 
	{
		mcqBeanList = new ArrayList<McqBean>();
		try
		{			
			con = DBConnectionFactory.getConnection();
			
			if(qCategoryId > 0 && qSubCategoryId > 0)
			{
				pst = con.prepareStatement("select * from mcq_question_info where q_category_id = ? and q_sub_category_id = ? limit ?");
				pst.setLong(1, qCategoryId);
				pst.setLong(2, qSubCategoryId);
				pst.setLong(3, showNoOfQuestion);
			}
			else if(qCategoryId > 0)
			{
				pst = con.prepareStatement("select * from mcq_question_info where q_category_id = ? limit ?");
				pst.setLong(1, qCategoryId);
				pst.setLong(2, showNoOfQuestion);
			}
			else
			{
				pst = con.prepareStatement("select * from mcq_question_info limit ?");				
				pst.setLong(1, showNoOfQuestion);
			}	
			rs = pst.executeQuery();
			while(rs.next())
			{
				mcqBean = new McqBean();
				mcqBean.setMcqId(rs.getLong("mcq_id"));
				mcqBean.setMcqQuestion(rs.getString("mcq_question"));
				mcqBean.setMcqAns1(rs.getString("mcq_ans_1"));
				mcqBean.setMcqAns2(rs.getString("mcq_ans_2"));
				mcqBean.setMcqAns3(rs.getString("mcq_ans_3"));
				mcqBean.setMcqAns4(rs.getString("mcq_ans_4"));
				mcqBean.setMcqCorrectAns(rs.getString("mcq_correct_ans"));
				mcqBean.setMcqCorrectId(rs.getLong("mcq_correct_id"));
				mcqBean.setMcqAnsDescription(rs.getString("mcq_ans_description"));
				mcqBean.setqCategoryId(rs.getLong("q_category_id"));
				mcqBean.setqSubCategoryId(rs.getLong("q_sub_category_id"));
				mcqBeanList.add(mcqBean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}		
		return mcqBeanList;		
	}

/*============================================== Search Descriptive for Model ================================================*/	
	
	
	public List<DescriptiveQBean> searchDescQuestionList(long qCategoryId, long qSubCategoryId, long showNoOfQuestion) 
	{
		descriptiveQBeanList = new ArrayList<DescriptiveQBean>();
		try
		{			
			con = DBConnectionFactory.getConnection();
			
			if(qCategoryId > 0 && qSubCategoryId > 0)
			{
				pst = con.prepareStatement("select * from descriptive_question_info where q_category_id = ? and q_sub_category_id = ? limit ?");
				pst.setLong(1, qCategoryId);
				pst.setLong(2, qSubCategoryId);
				pst.setLong(3, showNoOfQuestion);
			}
			else if(qCategoryId > 0)
			{
				pst = con.prepareStatement("select * from descriptive_question_info where q_category_id = ? limit ?");
				pst.setLong(1, qCategoryId);
				pst.setLong(2, showNoOfQuestion);
			}
			else
			{
				pst = con.prepareStatement("select * from descriptive_question_info limit ?");				
				pst.setLong(1, showNoOfQuestion);
			}	
			rs = pst.executeQuery();
			while(rs.next())
			{
				descriptiveQBean = new DescriptiveQBean();
				
				descriptiveQBean.setdQuestionId(rs.getLong("d_question_id"));
				descriptiveQBean.setdQuestion(rs.getString("d_question"));
				descriptiveQBean.setdQuestionAns(rs.getString("d_question_ans"));
				descriptiveQBean.setdQuestionMarks(rs.getLong("d_question_marks"));
				descriptiveQBean.setqCategoryId(rs.getLong("q_category_id"));
				descriptiveQBean.setqSubCategoryId(rs.getLong("q_sub_category_id"));	
				descriptiveQBeanList.add(descriptiveQBean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}		
		return descriptiveQBeanList;
	}	
	
	
/*===================================================== Save New Model Section ================================================*/	
	
	
	public QuestionModelBean addNewModel(QuestionModelBean questionModelBean) 
	{		
		try
		{
			con = DBConnectionFactory.getConnection();		
			pst = con.prepareStatement("insert into question_model(model_name, total_question, exam_time, model_description, model_question_type,  model_question) values(?, ?, ?, ?, ?, ?)");
			pst.setString(1, questionModelBean.getModelName());	
			pst.setLong(2, questionModelBean.getTotalQuestion());
			pst.setLong(3, questionModelBean.getExamTime());
			pst.setString(4, questionModelBean.getModelDescription());
			pst.setLong(5, questionModelBean.getModelQuestionType());
			pst.setString(6, questionModelBean.getModelQuestion());				
			status = pst.executeUpdate();
			if(status > 0)
			{
				System.out.println("Successfully");
				pst = con.prepareStatement("select max(model_id) from question_model");
				rs = pst.executeQuery();				
				while(rs.next())
				{
					System.out.println("MAX Model ID : "+rs.getLong(1));
					questionModelBean.setModelId(rs.getLong(1));					
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		return questionModelBean;
	}

/*===================================================== Save New Model Section ================================================*/	
	
	
	public List<QuestionModelBean> showModelQSet() 
	{
		questionModelBeanList = new ArrayList<QuestionModelBean>();
		
		try
		{
			con = DBConnectionFactory.getConnection();		
			pst = con.prepareStatement("select * from question_model");			
			rs = pst.executeQuery();
			while(rs.next())
			{
				questionModelBean = new QuestionModelBean();
				questionModelBean.setModelId(rs.getLong("model_id"));
				questionModelBean.setModelName(rs.getString("model_name"));
				questionModelBean.setTotalQuestion(rs.getLong("total_question"));
				questionModelBean.setExamTime(rs.getLong("exam_time"));
				questionModelBean.setModelDescription(rs.getString("model_description"));
				questionModelBean.setModelQuestionType(rs.getLong("model_question_type"));
				questionModelBean.setModelQuestion(rs.getString("model_question"));
				questionModelBeanList.add(questionModelBean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				pst.close();
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}		
		}
		
		return questionModelBeanList;
	}
	
}
