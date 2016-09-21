package com.mayabious.examsystem.bean;

import java.io.Serializable;

public class QuestionModelBean implements Serializable
{
	private static final long serialVersionUID = -746521740481720084L;
	
	private long modelId;
	private String modelName;		
	private long totalQuestion;
	private long examTime;
	private String modelDescription;
	
	private long modelQuestionType;
	private long qCategoryId;
	private long qSubCategoryId;	
	private long showNoOfQuestion;
	private String modelQuestion;
	
	public long getModelId() {
		return modelId;
	}
	public void setModelId(long modelId) {
		this.modelId = modelId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelDescription() {
		return modelDescription;
	}
	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}
	public long getExamTime() {
		return examTime;
	}
	public void setExamTime(long examTime) {
		this.examTime = examTime;
	}
	public String getModelQuestion() {
		return modelQuestion;
	}
	public void setModelQuestion(String modelQuestion) {
		this.modelQuestion = modelQuestion;
	}
	public long getqCategoryId() {
		return qCategoryId;
	}
	public void setqCategoryId(long qCategoryId) {
		this.qCategoryId = qCategoryId;
	}
	public long getShowNoOfQuestion() {
		return showNoOfQuestion;
	}
	public void setShowNoOfQuestion(long showNoOfQuestion) {
		this.showNoOfQuestion = showNoOfQuestion;
	}
	public long getTotalQuestion() {
		return totalQuestion;
	}
	public void setTotalQuestion(long totalQuestion) {
		this.totalQuestion = totalQuestion;
	}
	public long getqSubCategoryId() {
		return qSubCategoryId;
	}
	public void setqSubCategoryId(long qSubCategoryId) {
		this.qSubCategoryId = qSubCategoryId;
	}
	public long getModelQuestionType() {
		return modelQuestionType;
	}
	public void setModelQuestionType(long modelQuestionType) {
		this.modelQuestionType = modelQuestionType;
	}
	
	@Override
	public String toString() {
		return "QuestionModelBean [modelId=" + modelId + ", modelName=" + modelName + ", totalQuestion=" + totalQuestion
				+ ", examTime=" + examTime + ", modelDescription=" + modelDescription + ", modelQuestionType="
				+ modelQuestionType + ", qCategoryId=" + qCategoryId + ", qSubCategoryId=" + qSubCategoryId
				+ ", showNoOfQuestion=" + showNoOfQuestion + ", modelQuestion=" + modelQuestion + "]";
	}
	
}
