package com.mayabious.examsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mayabious.examsystem.bean.CandidateBean;
import com.mayabious.examsystem.dao.CandidateDao;
import com.mayabious.examsystem.dao.CandidateDaoImpl;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService
{
	@Autowired
	private CandidateDao candidateDao;
	
	public CandidateBean getCDetails(String cMobile) 
	{
		
		return candidateDao.getCDetails(cMobile);
	}


	
	public CandidateBean saveCInfo(CandidateBean candidateBean) 
	{
		
		return candidateDao.saveCInfo(candidateBean);
	}


	
	public CandidateBean updateCProfile(CandidateBean candidateBean) 
	{
		
		return candidateDao.updateCProfile(candidateBean);
	}

}
