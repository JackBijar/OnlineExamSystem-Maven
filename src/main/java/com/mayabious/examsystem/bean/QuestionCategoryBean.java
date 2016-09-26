package com.mayabious.examsystem.bean;

import java.io.Serializable;

public class QuestionCategoryBean implements Serializable
{
	private static final long serialVersionUID = 8902332941322989936L;
	
	private long qCategoryId;
	private String qCategoryName;
	private String qCategoryDescription;
	
	public long getqCategoryId() {
		return qCategoryId;
	}
	public void setqCategoryId(long qCategoryId) {
		this.qCategoryId = qCategoryId;
	}
	public String getqCategoryName() {
		return qCategoryName;
	}
	public void setqCategoryName(String qCategoryName) {
		this.qCategoryName = qCategoryName;
	}	
	public String getqCategoryDescription() {
		return qCategoryDescription;
	}
	public void setqCategoryDescription(String qCategoryDescription) {
		this.qCategoryDescription = qCategoryDescription;
	}
	
	@Override
	public String toString() {
		return "QuestionCategoryBean [qCategoryId=" + qCategoryId + ", qCategoryName=" + qCategoryName + "]";
	}
	
}
