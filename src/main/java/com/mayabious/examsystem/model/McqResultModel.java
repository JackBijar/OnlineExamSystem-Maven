package com.mayabious.examsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mcq_result")
public class McqResultModel implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="report_id")
	private long report_id;
	
	@Column(name="mcq_id")
	private long mcq_id;
	
	@Column(name="c_ans_id")
	private long c_ans_id;
	
	@Column(name="c_score")
	private long c_score;

	public long getReport_id() {
		return report_id;
	}

	public void setReport_id(long report_id) {
		this.report_id = report_id;
	}

	public long getMcq_id() {
		return mcq_id;
	}

	public void setMcq_id(long mcq_id) {
		this.mcq_id = mcq_id;
	}

	public long getC_ans_id() {
		return c_ans_id;
	}

	public void setC_ans_id(long c_ans_id) {
		this.c_ans_id = c_ans_id;
	}

	public long getC_score() {
		return c_score;
	}

	public void setC_score(long c_score) {
		this.c_score = c_score;
	}

	@Override
	public String toString() {
		return "McqResultModel [report_id=" + report_id + ", mcq_id=" + mcq_id + ", c_ans_id=" + c_ans_id + ", c_score="
				+ c_score + "]";
	}
}
