package com.mayabious.examsystem.business;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExamBusinessLogicImpl implements ExamBusinessLogic 
{
	ObjectMapper objectMapper = null;
	String jsonString = "";	
	Map<Long, Long> mcqResultMap = null;
	
	
	public String objectToJsonString(Object obj) 
	{		
		try 
		{
		 	objectMapper = new ObjectMapper();			 	
			jsonString = objectMapper.writeValueAsString(obj); 
		}
		catch (JsonGenerationException e) 
		{
			e.printStackTrace();
		} catch (JsonMappingException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Class : "+obj.getClass().getName()+"\nJSON :: "+jsonString);
		return jsonString;
	}

	
	public Map<Long, Long> putJsonValueToMap(String mcqResult) 
	{
		Map<Long, Long> mcqResultMap = new HashMap<Long, Long>();
		
		System.out.println("STRING :: "+mcqResult);
		
		mcqResult = mcqResult.replaceAll("\\{","");
		mcqResult = mcqResult.replaceAll("\\}","");
		mcqResult = mcqResult.replaceAll("\\,",":");
		mcqResult = mcqResult.replaceAll("\\\"","");
		mcqResult = mcqResult.trim();
		
		System.out.println(mcqResult);
		
		String mcqResultArray [] = mcqResult.split(":");
		
		for(int i=0; i<mcqResultArray.length-1; i=i+2)			
		{			
			mcqResultMap.put(Long.parseLong(mcqResultArray[i]), Long.parseLong(mcqResultArray[i+1]));
		}		
		
		for ( Map.Entry<Long, Long> entry : mcqResultMap.entrySet()) 
		{		   
		    System.out.println("Key : "+entry.getKey()+" Values : "+entry.getValue());	
		}		
		
		return mcqResultMap;
	}

	
	
	public Map<Long, String> putJsonValueToMapForDescQ(String descResult) 
	{
		Map<Long, String> mcqResultMap = new HashMap<Long, String>();		
		
	    System.out.println("STRING : "+descResult);
	    
	    JsonParser parser = new JsonParser();
		
		JsonElement element = parser.parse(descResult);
		
		JsonObject obj = element.getAsJsonObject();
		
		Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();
		
		for (Map.Entry<String, JsonElement> entry: entries) 
		{   
			StringBuffer str = new StringBuffer(entry.getValue().toString());		    
		    str.replace(str.length()-1, str.length(), "");		    
		    str.replace(str.length()-str.length(), str.length()-(str.length()-1), "");	
		    
			mcqResultMap.put(Long.parseLong(entry.getKey()), str.toString().trim());
		}
		
		for ( Map.Entry<Long, String> entry : mcqResultMap.entrySet()) 
		{		   
		    System.out.println("Key : "+entry.getKey()+" Values : "+entry.getValue());	
		}			
		return mcqResultMap;
	}

}
