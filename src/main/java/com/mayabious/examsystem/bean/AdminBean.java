package com.mayabious.examsystem.bean;

import java.io.Serializable;

public class AdminBean implements Serializable
{	
	private static final long serialVersionUID = 2274339704308029959L;
	
	private long adminId;
	private String adminName;
	private String adminMobile;
	private String adminPass;
	private long adminRegStatus;
	
	
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminMobile() {
		return adminMobile;
	}
	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}		
	public long getAdminRegStatus() {
		return adminRegStatus;
	}
	public void setAdminRegStatus(long adminRegStatus) {
		this.adminRegStatus = adminRegStatus;
	}
	
	@Override
	public String toString() {
		return "AdminBean [adminId=" + adminId + ", adminName=" + adminName + ", adminMobile=" + adminMobile
				+ ", adminPass=" + adminPass + ", adminRegStatus=" + adminRegStatus + "]";
	}	
	
}
