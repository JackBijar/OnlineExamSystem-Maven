package com.mayabious.examsystem.bean;

import java.io.Serializable;
import java.util.Arrays;

public class CandidateBean implements Serializable
{
	private static final long serialVersionUID = -7956673982517057682L;
	
	private long cId;
	private String cName;
	private String cMobile;
	private String cEmail;
	private String cDob;
	private String cQualification;
	
	private String cSkill[];
	
	private String tempCSkill;
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
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
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
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}	
	
	public String[] getcSkill() 
	{
		return cSkill;
	}
	public void setcSkill(String[] cSkill) {
		this.cSkill = cSkill;
	}
	
	public String getTempCSkill() {
		return tempCSkill;
	}
	public void setTempCSkill(String tempCSkill) {
		this.tempCSkill = tempCSkill;
	}
	
	
	public String toString() {
		return "CandidateBean [cId=" + cId + ", cName=" + cName + ", cMobile=" + cMobile + ", cEmail=" + cEmail
				+ ", cDob=" + cDob + ", cQualification=" + cQualification + ", cSkill=" + Arrays.toString(cSkill)
				+ ", status=" + status + "]";
	}
		
}
