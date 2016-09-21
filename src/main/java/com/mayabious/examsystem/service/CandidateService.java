package com.mayabious.examsystem.service;

import com.mayabious.examsystem.bean.CandidateBean;

public interface CandidateService 
{
	public CandidateBean getCDetails(String cMobile);
	
	public CandidateBean saveCInfo(CandidateBean candidateBean);
	
	public CandidateBean updateCProfile(CandidateBean candidateBean);
	
}
