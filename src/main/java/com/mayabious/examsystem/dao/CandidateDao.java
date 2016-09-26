package com.mayabious.examsystem.dao;

import com.mayabious.examsystem.bean.CandidateBean;

public interface CandidateDao 
{
	public CandidateBean getCDetails(String cMobile);
	
	public CandidateBean saveCInfo(CandidateBean candidateBean);
	
	public CandidateBean updateCProfile(CandidateBean candidateBean);
}
