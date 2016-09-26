package com.mayabious.examsystem.bean;

import java.util.HashMap;
import java.util.Map;

public class ExamReportBean 
{
	private long reportId;
	private long mcqResult;
	private long descResult;
	private long total;
	private String grade;
	private long reportStatus;
	private long cId;
	
	private Map<Long, Long> mcqResultMap = new HashMap<Long, Long>();
	private Map<Long, String> descResultMap = new HashMap<Long, String>();

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public long getMcqResult() {
		return mcqResult;
	}

	public void setMcqResult(long mcqResult) {
		this.mcqResult = mcqResult;
	}

	public long getDescResult() {
		return descResult;
	}

	public void setDescResult(long descResult) {
		this.descResult = descResult;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public long getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(long reportStatus) {
		this.reportStatus = reportStatus;
	}

	public Map<Long, Long> getMcqResultMap() {
		return mcqResultMap;
	}

	public void setMcqResultMap(Map<Long, Long> mcqResultMap) {
		this.mcqResultMap = mcqResultMap;
	}

	public Map<Long, String> getDescResultMap() {
		return descResultMap;
	}

	public void setDescResultMap(Map<Long, String> descResultMap) {
		this.descResultMap = descResultMap;
	}
	
	public long getcId() {
		return cId;
	}

	public void setcId(long cId) {
		this.cId = cId;
	}

	@Override
	public String toString() {
		return "ExamReportBean [reportId=" + reportId + ", mcqResult=" + mcqResult + ", descResult=" + descResult
				+ ", total=" + total + ", grade=" + grade + ", reportStatus=" + reportStatus + ", mcqResultMap="
				+ mcqResultMap + ", descResultMap=" + descResultMap + "]";
	}		
	
}
