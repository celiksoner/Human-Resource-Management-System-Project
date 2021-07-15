package com.hrms.hrmsproject.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrmsproject.business.abstracts.JobPositionService;
import com.hrms.hrmsproject.entities.concretes.JobPosition;

@RestController
@RequestMapping("api/1.0/jobpositions")
public class JobPositionController {
	
	private JobPositionService jobPositionService;

	public JobPositionController(JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")
	public List<JobPosition> getAll(){
		return this.jobPositionService.getAll();
	}

}
