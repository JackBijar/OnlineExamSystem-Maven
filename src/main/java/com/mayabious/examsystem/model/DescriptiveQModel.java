package com.mayabious.examsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="descriptive_question_info")
public class DescriptiveQModel implements Serializable
{	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="d_question_id")
	private long dQuestionId;
	
	@Column(name="d_question")
	private String dQuestion;
	
	@Column(name="d_question_ans")
	private String dQuestionAns;
	
	@Column(name="d_question_marks")
	private long dQuestionMarks;
	
	//@Column(name="")
	private String cGivenAns;
	
	//@Column(name="")
	private long givenMarks;
	
	//@Column(name="")
	private long reportId;
	
	@Column(name="q_category_id")
	private long qCategoryId;
	
	@Column(name="q_sub_category_id")
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
		return "DescriptiveQModel [dQuestionId=" + dQuestionId + ", dQuestion=" + dQuestion + ", dQuestionAns="
				+ dQuestionAns + ", dQuestionMarks=" + dQuestionMarks + ", cGivenAns=" + cGivenAns + ", givenMarks="
				+ givenMarks + ", reportId=" + reportId + ", qCategoryId=" + qCategoryId + ", qSubCategoryId="
				+ qSubCategoryId + "]";
	}	
}
