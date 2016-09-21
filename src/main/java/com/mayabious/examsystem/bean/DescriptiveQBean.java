package com.mayabious.examsystem.bean;

import java.io.Serializable;

public class DescriptiveQBean implements Serializable
{	
	private static final long serialVersionUID = -4166254390711584534L;
	
	private long dQuestionId;
	private String dQuestion;
	private String dQuestionAns;
	private long dQuestionMarks;
	private String cGivenAns;
	private long givenMarks;
	private long reportId;
	private long qCategoryId;
	private long qSubCategoryId;
	
	
	public long getdQuestionId() {
		return dQuestionId;
	}
	public void setdQuestionId(long dQuestionId) {
		this.dQuestionId = dQuestionId;
	}
	public String getdQuestion() {
		return dQuestion;
	}
	public void setdQuestion(String dQuestion) {
		this.dQuestion = dQuestion;
	}
	public String getdQuestionAns() {
		return dQuestionAns;
	}
	public void setdQuestionAns(String dQuestionAns) {
		this.dQuestionAns = dQuestionAns;
	}
	public long getdQuestionMarks() {
		return dQuestionMarks;
	}
	public void setdQuestionMarks(long dQuestionMarks) {
		this.dQuestionMarks = dQuestionMarks;
	}	
	public String getcGivenAns() {
		return cGivenAns;
	}
	public void setcGivenAns(String cGivenAns) {
		this.cGivenAns = cGivenAns;
	}
	public long getGivenMarks() {
		return givenMarks;
	}
	public void setGivenMarks(long givenMarks) {
		this.givenMarks = givenMarks;
	}	
	public long getReportId() {
		return reportId;
	}
	public void setReportId(long reportId) {
		this.reportId = reportId;
	}
	public long getqCategoryId() {
		return qCategoryId;
	}
	public void setqCategoryId(long qCategoryId) {
		this.qCategoryId = qCategoryId;
	}
	public long getqSubCategoryId() {
		return qSubCategoryId;
	}
	public void setqSubCategoryId(long qSubCategoryId) {
		this.qSubCategoryId = qSubCategoryId;
	}
	
	@Override
	public String toString() {
		return "DescriptiveQBean [dQuestionId=" + dQuestionId + ", dQuestion=" + dQuestion + ", dQuestionAns="
				+ dQuestionAns + ", dQuestionMarks=" + dQuestionMarks + "]";
	}		
	
	
}
