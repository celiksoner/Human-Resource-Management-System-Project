package com.hrms.hrmsproject.business.abstracts;

import com.hrms.hrmsproject.core.utilities.results.Result;
import com.hrms.hrmsproject.entities.concretes.JobSeeker;

public interface JobSeekerCheckService {
	
	Result checkFirstName(JobSeeker jobSeeker);

	Result checkLastName(JobSeeker jobSeeker);

	Result checkNationalityId(JobSeeker jobSeeker);

	Result checkBirthYear(JobSeeker jobSeeker);

	Result checkEmail(JobSeeker jobSeeker);

	Result checkPassword(JobSeeker jobSeeker);

	Result checkRepeatPassword(JobSeeker jobSeeker);

	Result uniqueEmail(JobSeeker jobSeeker);

	Result uniqueNationalityId(JobSeeker jobseeker);
}
