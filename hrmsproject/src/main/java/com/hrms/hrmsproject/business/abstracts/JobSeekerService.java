package com.hrms.hrmsproject.business.abstracts;

import java.util.List;

import com.hrms.hrmsproject.core.utilities.results.DataResult;
import com.hrms.hrmsproject.core.utilities.results.Result;
import com.hrms.hrmsproject.entities.concretes.JobSeeker;

public interface JobSeekerService {
	Result add(JobSeeker jobseeker);
	DataResult<List<JobSeeker>> getAll();
}
