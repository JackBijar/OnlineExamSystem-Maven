package com.mayabious.examsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="question_category")
public class QuestionCategoryModel implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="q_category_id")	
	private long qCategoryId;
	
	@Column(name="q_category_name")
	private String qCategoryName;
	
	@Column(name="q_category_description")
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
		return "QuestionCategoryModel [qCategoryId=" + qCategoryId + ", qCategoryName=" + qCategoryName
				+ ", qCategoryDescription=" + qCategoryDescription + "]";
	}	
}
