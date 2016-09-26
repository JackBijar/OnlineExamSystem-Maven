package com.mayabious.examsystem.bean;

import java.io.Serializable;

public class McqBean implements Serializable
{	
	private static final long serialVersionUID = 6244047542150667228L;
	
	private long mcqId;
	private String mcqQuestion;
	private String mcqAns1;
	private String mcqAns2;
	private String mcqAns3;
	private String mcqAns4;
	private String mcqCorrectAns;
	private long mcqCorrectId;
	private String mcqAnsDescription;
	private long qCategoryId;
	private long qSubCategoryId;
	
	
	private long cGivenAnsId;
	
	
	public long getMcqId() {
		return mcqId;
	}
	public void setMcqId(long mcqId) {
		this.mcqId = mcqId;
	}
	public String getMcqQuestion() {
		return mcqQuestion;
	}
	public void setMcqQuestion(String mcqQuestion) {
		this.mcqQuestion = mcqQuestion;
	}
	public String getMcqAns1() {
		return mcqAns1;
	}
	public void setMcqAns1(String mcqAns1) {
		this.mcqAns1 = mcqAns1;
	}
	public String getMcqAns2() {
		return mcqAns2;
	}
	public void setMcqAns2(String mcqAns2) {
		this.mcqAns2 = mcqAns2;
	}
	public String getMcqAns3() {
		return mcqAns3;
	}
	public void setMcqAns3(String mcqAns3) {
		this.mcqAns3 = mcqAns3;
	}
	public String getMcqAns4() {
		return mcqAns4;
	}
	public void setMcqAns4(String mcqAns4) {
		this.mcqAns4 = mcqAns4;
	}
	public String getMcqCorrectAns() {
		return mcqCorrectAns;
	}
	public void setMcqCorrectAns(String mcqCorrectAns) {
		this.mcqCorrectAns = mcqCorrectAns;
	}
	public long getMcqCorrectId() {
		return mcqCorrectId;
	}
	public void setMcqCorrectId(long mcqCorrectId) {
		this.mcqCorrectId = mcqCorrectId;
	}	
	public long getcGivenAnsId() {
		return cGivenAnsId;
	}
	public void setcGivenAnsId(long cGivenAnsId) {
		this.cGivenAnsId = cGivenAnsId;
	}	
	public String getMcqAnsDescription() {
		return mcqAnsDescription;
	}
	public void setMcqAnsDescription(String mcqAnsDescription) {
		this.mcqAnsDescription = mcqAnsDescription;
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
		return "McqBean [mcqId=" + mcqId + ", mcqQuestion=" + mcqQuestion + ", mcqAns1=" + mcqAns1 + ", mcqAns2="
				+ mcqAns2 + ", mcqAns3=" + mcqAns3 + ", mcqAns4=" + mcqAns4 + ", mcqCorrectAns=" + mcqCorrectAns
				+ ", mcqCorrectId=" + mcqCorrectId + ", mcqAnsDescription=" + mcqAnsDescription + ", cGivenAnsId="
				+ cGivenAnsId + "]";
	}	
	
}
