package com.mayabious.examsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mayabious.examsystem.bean.CandidateBean;
import com.mayabious.examsystem.util.AdminDaoUtil;
import com.mayabious.examsystem.util.CandidateDaoUtil;

@Repository
public class CandidateDaoImpl implements CandidateDao 
{
	@Autowired
	private CandidateDaoUtil candidateDaoUtil;
	
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	CandidateBean candidateBean = null;
	int status = 0;
	
/*===================================================== Get Candidate Info =====================================================*/
	
	
	public CandidateBean getCDetails(String cMobile) 
	{
		candidateBean = new CandidateBean();		
		try
		{
			con = DBConnectionFactory.getConnection();
			pst = con.prepareStatement("select * from candidate_info where c_mobile = ?");
			pst.setString(1, cMobile);
			rs = pst.executeQuery();
			while(rs.next())
			{
				candidateBean.setcId(rs.getLong("c_id"));
				candidateBean.setcName(rs.getString("c_name"));
				candidateBean.setcMobile(rs.getString("c_mobile"));
				candidateBean.setcDob(rs.getString("c_dob"));
				candidateBean.setcQualification(rs.getString("c_qualification"));
				candidateBean.setcEmail(rs.getString("c_email"));
				candidateBean.setTempCSkill(rs.getString("c_skill"));
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
		return candidateBean;
	}

/*===================================================== Save Candidate Info =====================================================*/
	
	
	public CandidateBean saveCInfo(CandidateBean candidateBean) 
	{		
		try
		{
			con = DBConnectionFactory.getConnection();
			
			pst = con.prepareStatement("select * from candidate_info where c_mobile = ?"); /*=====Check Mobile No Exist OR Not======*/
			pst.setString(1, candidateBean.getcMobile());
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				System.out.println(candidateBean.getcMobile()+" This Mobile No Already Exist");
				
				pst = con.prepareStatement("update candidate_info set c_status = ? where c_id = ?"); /*=====If Exist Then Update Candidate Status======*/
				pst.setLong(1, rs.getLong("c_status")+1);
				pst.setLong(2, rs.getLong("c_id"));				
				int status2 = pst.executeUpdate();
				if(status2 > 0)
				{
					System.out.println("Successfull c_status Updated for Re-Registration candidate_info table");
				}
				candidateBean.setcId(rs.getLong(1));											/*-----Set cId into CandidateBean----*/
				
				pst = con.prepareStatement("insert into candidate_report(c_id, mcq_result, desc_result, total, grade, mcq_report_status, desc_report_status, check_desc_report_status) values(?, ?, ?, ?, ?, ?, ?, ?)"); 	/*-----New insert c_id into candidate_report----*/
				pst.setLong(1, rs.getLong(1));
				pst.setInt(2, 0);
				pst.setInt(3, 0);
				pst.setInt(4, 0);
				pst.setString(5, "");
				pst.setInt(6, 0);
				pst.setInt(7, 0);
				pst.setInt(8, 0);
				
				int status3 = pst.executeUpdate();
				if(status3 > 0)
					System.out.println("Successfull inserted c_id in candidate_report table");
			}
			else
			{			
				String str1="";
				for(int i=0; i<candidateBean.getcSkill().length; i++)
				{
					if(i==0)
						str1=candidateBean.getcSkill()[i];
					else
						str1+=","+candidateBean.getcSkill()[i];
				}				
				System.out.println("SKILL "+str1);
				
				pst = con.prepareStatement("insert into candidate_info(c_name, c_mobile, c_email, c_dob, c_qualification, c_skill, c_status) values(?, ?, ?, ?, ?, ?, ?)");
				pst.setString(1, candidateBean.getcName());														
				pst.setString(2, candidateBean.getcMobile());								/*=====If Not Exist Then Insert into Candidate======*/
				pst.setString(3, candidateBean.getcEmail());
				pst.setString(4, candidateBean.getcDob());
				pst.setString(5, candidateBean.getcQualification());
				pst.setString(6, str1);
				pst.setLong(7, 1);
				
				status = pst.executeUpdate();
				if(status > 0)
				{
					pst = con.prepareStatement("select max(c_id) from candidate_info");		/*-----Set cId into CandidateBean----*/
					rs = pst.executeQuery();				
					while(rs.next())
					{
						System.out.println("MAX ID : "+rs.getLong(1));
						candidateBean.setcId(rs.getLong(1));
						
						pst = con.prepareStatement("insert into candidate_report(c_id, mcq_result, desc_result, total, grade, mcq_report_status, desc_report_status, check_desc_report_status) values(?, ?, ?, ?, ?, ?, ?, ?)"); 	/*-----New insert c_id into candidate_report----*/
						pst.setLong(1, rs.getLong(1));
						pst.setInt(2, 0);
						pst.setInt(3, 0);
						pst.setInt(4, 0);
						pst.setString(5, "");
						pst.setInt(6, 0);
						pst.setInt(7, 0);
						pst.setInt(8, 0);
						
						int status3 = pst.executeUpdate();
						if(status3 > 0)
							System.out.println("Successfull inserted c_id in candidate_report table");
					}
				}
				else
					System.out.println("Not Successfully Inserted");
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
		return candidateBean;
	}
	
/*===================================================== Update Candidate Profile =====================================================*/	
	
	
	public CandidateBean updateCProfile(CandidateBean candidateBean) 
	{		
		try
		{
			con = DBConnectionFactory.getConnection();
			
			String skill="";
			for(int i=0; i<candidateBean.getcSkill().length; i++)
			{
				if(i==0)
					skill=candidateBean.getcSkill()[i];
				else
					skill+=","+candidateBean.getcSkill()[i];
			}				
			System.out.println("SKILL "+skill);
			
			pst = con.prepareStatement("update candidate_info set c_name = ?, c_dob = ?, c_qualification = ?, c_skill = ? "
											+ "c_email = ?, where c_id = ?");
			
			pst.setString(1, candidateBean.getcName());
			pst.setString(2, candidateBean.getcDob());
			pst.setString(3, candidateBean.getcQualification());
			pst.setString(4, skill);
			pst.setString(5, candidateBean.getcEmail());
			pst.setLong(6, candidateBean.getcId());
			
			status = pst.executeUpdate();
			
			if(status > 0)
			{
				pst = con.prepareStatement("select * from candidate_info where c_id = ?"); 
				pst.setLong(1, candidateBean.getcId());
				rs = pst.executeQuery();	
				
				while(rs.next())
				{
					candidateBean.setcName(rs.getString("c_name"));
					candidateBean.setcEmail(rs.getString("c_email"));
					candidateBean.setcDob(rs.getString("c_dob"));
					candidateBean.setcQualification("c_qualification");
					candidateBean.setTempCSkill(skill);
				}
			}
			else
				System.out.println("Not Successfully Updated");
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
		return candidateBean;
	}

	
	
}
