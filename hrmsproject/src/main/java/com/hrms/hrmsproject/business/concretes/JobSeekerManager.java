package com.hrms.hrmsproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrmsproject.business.abstracts.JobSeekerCheckService;
import com.hrms.hrmsproject.business.abstracts.JobSeekerService;
import com.hrms.hrmsproject.core.utilities.business.BusinessRules;
import com.hrms.hrmsproject.core.utilities.results.DataResult;
import com.hrms.hrmsproject.core.utilities.results.Result;
import com.hrms.hrmsproject.core.utilities.results.SuccessDataResult;
import com.hrms.hrmsproject.core.utilities.results.SuccessResult;
import com.hrms.hrmsproject.dataAccess.abstracts.JobSeekerDao;
import com.hrms.hrmsproject.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerCheckService jobSeekerCheckService;
	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerCheckService jobSeekerCheckService, JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerCheckService = jobSeekerCheckService;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(JobSeeker jobseeker) {

		Result result = BusinessRules.run(jobSeekerCheckService.checkFirstName(jobseeker),
				jobSeekerCheckService.checkLastName(jobseeker), jobSeekerCheckService.checkNationalityId(jobseeker),
				jobSeekerCheckService.checkBirthYear(jobseeker), jobSeekerCheckService.checkEmail(jobseeker),
				jobSeekerCheckService.checkPassword(jobseeker), jobSeekerCheckService.checkRepeatPassword(jobseeker),
				jobSeekerCheckService.uniqueEmail(jobseeker), jobSeekerCheckService.uniqueNationalityId(jobseeker));

		if (result != null) {
			return result;
		}else {
			jobSeekerDao.save(jobseeker);
		}
		return new SuccessResult();

	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobSeeker>>( jobSeekerDao.findAll());
	}

}
