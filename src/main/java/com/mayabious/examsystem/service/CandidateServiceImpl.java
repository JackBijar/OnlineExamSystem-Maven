package com.mayabious.examsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mayabious.examsystem.bean.CandidateBean;
import com.mayabious.examsystem.dao.CandidateDao;
import com.mayabious.examsystem.dao.CandidateDaoImpl;
import com.mayabious.examsystem.model.CandidateModel;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService
{
	@Autowired
	private CandidateDao candidateDao;
	
	public CandidateModel getCDetails(String cMobile) 
	{		
		return candidateDao.getCDetails(cMobile);
	}
	
	public CandidateModel saveCInfo(CandidateModel candidateModel) 
	{		
		return candidateDao.saveCInfo(candidateModel);
	}
	
	public CandidateModel updateCProfile(CandidateModel candidateModel) 
	{		
		return candidateDao.updateCProfile(candidateModel);
	}

}
