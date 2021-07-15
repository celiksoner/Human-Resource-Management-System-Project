package com.hrms.hrmsproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrmsproject.business.abstracts.JobPositionService;
import com.hrms.hrmsproject.dataAccess.abstracts.JobPositionDao;
import com.hrms.hrmsproject.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}


	@Override
	public List<JobPosition> getAll() {
		// TODO Auto-generated method stub
		return this.jobPositionDao.findAll();
	}

	

}
