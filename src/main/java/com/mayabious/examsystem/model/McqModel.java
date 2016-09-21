package com.mayabious.examsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mcq_question_info")
public class McqModel implements Serializable
{	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mcq_id")
	private long mcqId;
	
	@Column(name="mcq_question")
	private String mcqQuestion;
	
	@Column(name="mcq_ans_1")
	private String mcqAns1;
	
	@Column(name="mcq_ans_2")
	private String mcqAns2;
	
	@Column(name="mcq_ans_3")
	private String mcqAns3;
	
	@Column(name="mcq_ans_4")
	private String mcqAns4;
	
	@Column(name="mcq_correct_ans")
	private String mcqCorrectAns;
	
	@Column(name="mcq_correct_id")
	private long mcqCorrectId;
	
	@Column(name="mcq_ans_description")
	private String mcqAnsDescription;
	
	@Column(name="q_category_id")
	private long qCategoryId;
	
	@Column(name="q_sub_category_id")
	private long qSubCategoryId;

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
		return "McqModel [mcqId=" + mcqId + ", mcqQuestion=" + mcqQuestion + ", mcqAns1=" + mcqAns1 + ", mcqAns2="
				+ mcqAns2 + ", mcqAns3=" + mcqAns3 + ", mcqAns4=" + mcqAns4 + ", mcqCorrectAns=" + mcqCorrectAns
				+ ", mcqCorrectId=" + mcqCorrectId + ", mcqAnsDescription=" + mcqAnsDescription + ", qCategoryId="
				+ qCategoryId + ", qSubCategoryId=" + qSubCategoryId + "]";
	}	
	
}
