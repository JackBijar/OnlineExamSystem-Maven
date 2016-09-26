package com.mayabious.examsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="model_question")
public class ModelQuestionModel implements Serializable
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "model_id")
	private long modelId;
	
	@Column(name = "model_name")
	private String modelName;	
	
	@Column(name = "total_question")
	private long totalQuestion;
	
	@Column(name = "exam_time")
	private long examTime;
	
	@Column(name = "model_description")
	private String modelDescription;
	
	
	@Column(name = "model_question_type")
	private long modelQuestionType;
	
	//@Column(name = "")
	private long qCategoryId;
	
	//@Column(name = "")
	private long qSubCategoryId;	
	
	//@Column(name = "")
	private long showNoOfQuestion;
	
	@Column(name = "model_question")
	private String modelQuestion;
	
	
}
