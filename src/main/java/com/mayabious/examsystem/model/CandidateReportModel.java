package com.mayabious.examsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidate_report")
public class CandidateReportModel implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "report_id")
	private long reportId;
	
	@Column(name="c_id")
	private long cId;
	
	@Column(name="mcq_result")
	private int mcqResult;
	
	@Column(name="desc_result")
	private int descResult;
	
	@Column(name="total")
	private int total;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="mcq_report_status")
	private int mcqReportStatus;
	
	@Column(name="desc_report_status")
	private int descReportStatus;
	
	@Column(name="check_desc_report_status")
	private int checkDescReportStatus;

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public long getcId() {
		return cId;
	}

	public void setcId(long cId) {
		this.cId = cId;
	}

	public int getMcqResult() {
		return mcqResult;
	}

	public void setMcqResult(int mcqResult) {
		this.mcqResult = mcqResult;
	}

	public int getDescResult() {
		return descResult;
	}

	public void setDescResult(int descResult) {
		this.descResult = descResult;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getMcqReportStatus() {
		return mcqReportStatus;
	}

	public void setMcqReportStatus(int mcqReportStatus) {
		this.mcqReportStatus = mcqReportStatus;
	}

	public int getDescReportStatus() {
		return descReportStatus;
	}

	public void setDescReportStatus(int descReportStatus) {
		this.descReportStatus = descReportStatus;
	}

	public int getCheckDescReportStatus() {
		return checkDescReportStatus;
	}

	public void setCheckDescReportStatus(int checkDescReportStatus) {
		this.checkDescReportStatus = checkDescReportStatus;
	}
	
	@Override
	public String toString() 
	{
		return "CandidateReportModel [reportId=" + reportId + ", cId=" + cId + ", mcqResult=" + mcqResult
				+ ", descResult=" + descResult + ", total=" + total + ", grade=" + grade + ", mcqReportStatus="
				+ mcqReportStatus + ", descReportStatus=" + descReportStatus + ", checkDescReportStatus="
				+ checkDescReportStatus + "]";
	}
}
