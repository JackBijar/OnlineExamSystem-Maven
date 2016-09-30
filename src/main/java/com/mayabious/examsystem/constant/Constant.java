package com.mayabious.examsystem.constant;

public final class Constant 
{	 
	 
//--------------------------------------------------COMMON CONSTANTS-----------------------------------------------------------//
 
	 public static final String INDEX_PAGE = "index";
	 public static final String LOGIN_STATUS = "loginStatus";
	 public static final String REG_STATUS = "singUpStatus";
	 
	 public static final String NOT_REG_STATUS_MSG = "Some Problem Not Successfuly... Sing Up";
	 
	 public static final String HIBERNATE_ERROR_STATUS = "HIBERNATE ERROR STATUS : ";
	 public static final String LOGGER_STATUS = "LOGGER STATUS : "; 
	
//------------------------------------------------------ADMIN CONSTANTS--------------------------------------------------------//
	 
	 public static final long INACTIVE_ADMIN_REG_STATUS = 0;
	 public static final long ACTIVE_ADMIN_REG_STATUS = 1;
	 
	 public static final long TEST_MOBILE_NO = 0000;	
	 
//------------------------------------------------------CANDIDATE CONTANS------------------------------------------------------//	 
	 
	 public static final String C_HOME_PAGE = "candidateHome";
	 public static final String CANDIDATE_MODEL = "candidateModel";
	 
	 
	 public static final String NOT_REG_C_MSG = "You are Not a Register Candidate, Please Sing Up";

//----------------------------------------------------------TEMP CONSTANTS------------------------------------------------------//	 
	 
	 public static final boolean PASSES = true;	 
	 public static final String EMPTY_STRING = "";
	 public static final String SPACE = " ";
	 public static final String TAB = "\t";
	 public static final String SINGLE_QUOTE = "'";
	 public static final String PERIOD = ".";
	 public static final String DOUBLE_QUOTE = "\"";
	 
//----------------------------------------------------------REQURIED METHODS----------------------------------------------------//
	 
	 private Constant(){}
}
