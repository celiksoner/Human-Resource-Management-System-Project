package com.hrms.hrmsproject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrmsproject.business.abstracts.JobSeekerService;
import com.hrms.hrmsproject.core.utilities.results.Result;
import com.hrms.hrmsproject.entities.concretes.JobSeeker;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/jobseeker")
public class JobSeekerController {
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@PostMapping("/addjobseeker")
	public Result add(@RequestBody JobSeeker jobseeker) {
		return this.jobSeekerService.add(jobseeker);
	}
	
	

}
