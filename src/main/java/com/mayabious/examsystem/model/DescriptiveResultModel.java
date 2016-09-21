package com.mayabious.examsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="descriptive_result")
public class DescriptiveResultModel implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="report_id")
	private long reportId ;
	
	@Column(name="d_question_id")
	private long dQuestionId ;
	
	@Column(name="given_marks")
	private long givenMarks ;
	
	@Column(name="c_given_ans")
	private String cGivenAns ;

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public long getdQuestionId() {
		return dQuestionId;
	}

	public void setdQuestionId(long dQuestionId) {
		this.dQuestionId = dQuestionId;
	}

	public long getGivenMarks() {
		return givenMarks;
	}

	public void setGivenMarks(long givenMarks) {
		this.givenMarks = givenMarks;
	}

	public String getcGivenAns() {
		return cGivenAns;
	}

	public void setcGivenAns(String cGivenAns) {
		this.cGivenAns = cGivenAns;
	}

	@Override
	public String toString() {
		return "DescriptiveResultModel [reportId=" + reportId + ", dQuestionId=" + dQuestionId + ", givenMarks="
				+ givenMarks + ", cGivenAns=" + cGivenAns + "]";
	}
	
	/*@Column(name="")
	private  ;*/
}
