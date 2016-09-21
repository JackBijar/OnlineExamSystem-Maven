package com.mayabious.examsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidate_info")
public class CandidateModel implements Serializable
{	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "c_id")
	private long cId;
	
	@Column(name = "c_name")
	private String cName;
	
	@Column(name = "c_mobile")
	private String cMobile;
	
	@Column(name = "c_email")
	private String cEmail;	
	
	@Column(name = "c_dob")
	private String cDob;
	
	@Column(name = "c_qualification")
	private String cQualification;
		
	@Column(name = "c_skill")
	private String cSkill;
	
	@Column(name = "c_status")
	private int cStatus;
	
	private String tempCSkill;		//Check it
	private long status;
	
	
	public long getcId() {
		return cId;
	}

	public void setcId(long cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcMobile() {
		return cMobile;
	}

	public void setcMobile(String cMobile) {
		this.cMobile = cMobile;
	}

	public String getcDob() {
		return cDob;
	}

	public void setcDob(String cDob) {
		this.cDob = cDob;
	}

	public String getcQualification() {
		return cQualification;
	}

	public void setcQualification(String cQualification) {
		this.cQualification = cQualification;
	}
	
	public int getcStatus() {
		return cStatus;
	}

	public void setcStatus(int cStatus) {
		this.cStatus = cStatus;
	}

	public String getcSkill() {
		return cSkill;
	}

	public void setcSkill(String cSkill) {
		this.cSkill = cSkill;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getTempCSkill() {
		return tempCSkill;
	}

	public void setTempCSkill(String tempCSkill) {
		this.tempCSkill = tempCSkill;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CandidateModel [cId=" + cId + ", cName=" + cName + ", cMobile=" + cMobile + ", cEmail=" + cEmail
				+ ", cDob=" + cDob + ", cQualification=" + cQualification + ", cSkill=" + cSkill + ", cStatus="
				+ cStatus + ", tempCSkill=" + tempCSkill + ", status=" + status + "]";
	}
	
}
