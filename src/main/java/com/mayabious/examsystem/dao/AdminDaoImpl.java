package com.mayabious.examsystem.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mayabious.examsystem.bean.AdminBean;
import com.mayabious.examsystem.bean.CandidateBean;
import com.mayabious.examsystem.model.AdminModel;
import com.mayabious.examsystem.util.AdminDaoUtil;

@Repository
public class AdminDaoImpl implements AdminDao 
{	
	@Autowired
	private AdminDaoUtil adminDaoUtil;
	
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	//AdminBean adminBean = null;
	AdminModel adminModel = null;
	
	CandidateBean candidateBean = null;
	List<AdminModel> adminModelList;
	
	int status = 0;	
	long result = 0;
	    
	public AdminModel getAdminDetails(String adminMobile, String adminPass) 
	{
		adminModel = new AdminModel();
		try
		{
			con = DBConnectionFactory.getConnection();
			pst = con.prepareStatement("select * from admin_info where admin_mobile = ? and admin_pass = ?");
			pst.setString(1, adminMobile);
			pst.setString(2, adminPass);
			rs = pst.executeQuery();
			if(rs.next())
			{
				adminModel.setAdminId(rs.getLong("admin_id"));
				adminModel.setAdminName(rs.getString("admin_name"));
				adminModel.setAdminMobile(rs.getString("admin_mobile"));
				adminModel.setAdminPass(rs.getString("admin_pass"));
				adminModel.setAdminRegStatus(rs.getInt("admin_reg_status"));
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
		return adminModel;
	}

	
	public AdminModel saveAdminInfo(AdminModel adminModel) 
	{			
		try
		{
			con = DBConnectionFactory.getConnection();
			
			result = adminDaoUtil.saveAdminInfo(adminModel);
			
			if(status > 0)
			{
				pst = con.prepareStatement("select max(admin_id) from admin_info");
				rs = pst.executeQuery();				
				while(rs.next())
				{
					System.out.println("MAX ID : "+rs.getLong(1));
					adminModel.setAdminId(rs.getLong(1));
				}
			}
			else
				System.out.println("Not Successfully Inserted");
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
		return adminModel;
	}

	
	public List<AdminModel> getInActiveAdmin() 
	{
		adminModelList = new ArrayList<AdminModel>();
		try
		{
			con = DBConnectionFactory.getConnection();
			pst = con.prepareStatement("select * from admin_info where admin_reg_status=?");
			pst.setInt(1, 0);
			rs = pst.executeQuery();				
			while(rs.next())
			{
				adminModel = new AdminModel();
				adminModel.setAdminId(rs.getLong("admin_id"));
				adminModel.setAdminName(rs.getString("admin_name"));
				adminModel.setAdminMobile(rs.getString("admin_mobile"));
				adminModel.setAdminRegStatus(rs.getInt("admin_reg_status"));
				adminModelList.add(adminModel);
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
		return adminModelList;
	}

	
	public int activeAdminAccess(long adminId) 
	{
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("update admin_info set admin_reg_status = ? where admin_id = ?");
			pst.setInt(1, 1);
			pst.setLong(2, adminId);
			status = pst.executeUpdate();
			
			if(status > 0)
				status = 1;
			else
				status = 0;
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

/*------------------------------------------------------------Get Candidate Details---------------------------------------------*/
	
	public CandidateBean getCandidateinfo(long cId) 
	{
		candidateBean = new CandidateBean();		
		try
		{
			con = DBConnectionFactory.getConnection();			
			pst = con.prepareStatement("select * from candidate_info where c_id = ?");			
			pst.setLong(1, cId);
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				candidateBean.setcId(rs.getLong("c_id"));
				candidateBean.setcName(rs.getString("c_name"));
				candidateBean.setcMobile(rs.getString("c_mobile"));
				candidateBean.setcDob(rs.getString("c_dob"));
				candidateBean.setcEmail(rs.getString("c_email"));
				candidateBean.setcQualification(rs.getString("c_qualification"));
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
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}		
		return candidateBean;
	}

/*------------------------------------------------------------Chear Candidate Info---------------------------------------------*/	
	
	public int clearExamInfo(long cMobile) 
	{
		long cId = 0;
		long reportId = 0;
		try
		{
			con = DBConnectionFactory.getConnection();	
			pst = con.prepareStatement("select c_id from candidate_info where c_mobile = ?");
			pst.setLong(1, cMobile);
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				cId = rs.getLong("c_id");
				System.out.println("cId : "+cId);
			}
			
			pst = con.prepareStatement("select max(report_id) from candidate_report where c_id = ?");
			pst.setLong(1, cId);
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				reportId = rs.getLong(1);
				System.out.println("reportId : "+reportId);
			}
			
			pst = con.prepareStatement("delete from mcq_result where report_id = ?");			
			pst.setLong(1, reportId);
			status = pst.executeUpdate();
			System.out.println("Status =1= "+status);
			if(status > 0)
			{
				System.out.println("Successfully Deleted Mcq Result");	
				status = 0;
			}
			else
				System.out.println("Not Deleted Mcq Result");
			
			pst = con.prepareStatement("delete from descriptive_result where report_id = ?");			
			pst.setLong(1, reportId);
			status = pst.executeUpdate();
			System.out.println("Status =2= "+status);
			if(status > 0)
			{
				status = 0;
				System.out.println("Successfully Deleted Descriptive Result");
			}
			else
				System.out.println("Not Deleted Descriptive Result");
			pst = con.prepareStatement("update candidate_report set mcq_result = ? , desc_result = ?, total = ?, grade = ?,"
											+ "mcq_report_status = ?, desc_report_status = ?, check_desc_report_status = ? "
											+ "where report_id = ?");
			pst.setLong(1, 0);
			pst.setLong(2, 0);
			pst.setLong(3, 0);
			pst.setString(4, "");
			pst.setLong(5, 0);
			pst.setLong(6, 0);
			pst.setLong(7, 0);
			pst.setLong(8, reportId);
			status = pst.executeUpdate();
			if(status > 0)
			{
				System.out.println("Update Successfully");
			}
			else
				System.out.println("Table Not Update");
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
	
}
