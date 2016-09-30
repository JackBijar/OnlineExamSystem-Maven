package com.mayabious.examsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_info")
public class AdminModel implements Serializable
{	
	private static final long serialVersionUID = -701008185257147848L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="admin_id")
	private long adminId;
	
	@Column(name="admin_name")
	private String adminName;
	
	@Column(name="admin_mobile")
	private String adminMobile;
	
	@Column(name="admin_pass")
	private String adminPass;

	@Column(name="admin_reg_status", nullable = false, columnDefinition = "int default 100")	//check default
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

	public void setAdminRegStatus(long commonObjList) {
		this.adminRegStatus = commonObjList;
	}

	@Override
	public String toString() {
		return "AdminModel [adminId=" + adminId + ", adminName=" + adminName + ", adminMobile=" + adminMobile
				+ ", adminPass=" + adminPass + ", adminRegStatus=" + adminRegStatus + "]";
	}
	
}
