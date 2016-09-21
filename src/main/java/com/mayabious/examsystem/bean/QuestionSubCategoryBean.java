package com.mayabious.examsystem.bean;

import java.io.Serializable;

public class QuestionSubCategoryBean implements Serializable
{
	private static final long serialVersionUID = -5534225015332965483L;
	
	private long qSubCategoryId;
	private long qCategoryId;
	private String qSubCategoryName;
	
	
	public long getqSubCategoryId() {
		return qSubCategoryId;
	}
	public void setqSubCategoryId(long qSubCategoryId) {
		this.qSubCategoryId = qSubCategoryId;
	}
	public long getqCategoryId() {
		return qCategoryId;
	}
	public void setqCategoryId(long qCategoryId) {
		this.qCategoryId = qCategoryId;
	}
	public String getqSubCategoryName() {
		return qSubCategoryName;
	}
	public void setqSubCategoryName(String qSubCategoryName) {
		this.qSubCategoryName = qSubCategoryName;
	}	
	
	
}
