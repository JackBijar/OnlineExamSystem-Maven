package com.mayabious.examsystem.service;

import com.mayabious.examsystem.model.CandidateModel;

public interface CandidateService 
{
	public CandidateModel getCDetails(String cMobile);
	
	public CandidateModel saveCInfo(CandidateModel candidateModel);
	
	public CandidateModel updateCProfile(CandidateModel candidateModel);
	
}
