package com.mayabious.examsystem.business;

import java.util.Map;

public interface ExamBusinessLogic 
{
	public String objectToJsonString(Object obj);
	
	public Map<Long, Long> putJsonValueToMap(String mcqResult);
	
	public Map<Long, String> putJsonValueToMapForDescQ(String descResult);
}
