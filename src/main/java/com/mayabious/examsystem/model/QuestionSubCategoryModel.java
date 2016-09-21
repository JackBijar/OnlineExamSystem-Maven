package com.mayabious.examsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question_sub_category")
public class QuestionSubCategoryModel implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "q_sub_category_id")
	private long qSubCategoryId;
	
	@Column(name = "q_category_id")
	private long qCategoryId;
	
	@Column(name = "q_sub_category_name")
	private String qSubCategoryName;
	
	@Column(name = "q_sub_category_marks")
	private long qSubCategoryMarks;

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

	public long getqSubCategoryMarks() {
		return qSubCategoryMarks;
	}

	public void setqSubCategoryMarks(long qSubCategoryMarks) {
		this.qSubCategoryMarks = qSubCategoryMarks;
	}

	@Override
	public String toString() {
		return "QuestionSubCategoryModel [qSubCategoryId=" + qSubCategoryId + ", qCategoryId=" + qCategoryId
				+ ", qSubCategoryName=" + qSubCategoryName + ", qSubCategoryMarks=" + qSubCategoryMarks + "]";
	}
}
