package com.hrms.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrmsproject.entities.concretes.JobSeeker;


public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	JobSeeker findByEmail(String email);
	JobSeeker findByNationalityId (String nationalityId);
}
