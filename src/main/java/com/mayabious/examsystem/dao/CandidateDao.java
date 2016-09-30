package com.mayabious.examsystem.dao;

import com.mayabious.examsystem.model.CandidateModel;

public interface CandidateDao 
{
	public CandidateModel getCDetails(String cMobile);
	
	public CandidateModel saveCInfo(CandidateModel candidateModel);
	
	public CandidateModel updateCProfile(CandidateModel candidateModel);
}
