package com.hrms.hrmsproject.business.abstracts;

import java.util.List;

import com.hrms.hrmsproject.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
