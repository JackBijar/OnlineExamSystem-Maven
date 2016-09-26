package com.mayabious.examsystem.bean;

import java.io.Serializable;

public class ErrorMessageBean implements Serializable
{
	private static final long serialVersionUID = -6868176578031608066L;
	
	private String message;	
	

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
	
}
