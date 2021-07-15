package com.hrms.hrmsproject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "job_seekers")
@Data
public class JobSeeker {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "tc_no")
	private String tcKimlikNo;
	@Column(name = "birth_year")
	private int birthYear;

	public JobSeeker() {
	}

	public JobSeeker(int id, String firstName, String lastName, String tcKimlikNo, int birthYear) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tcKimlikNo = tcKimlikNo;
		this.birthYear = birthYear;
	}

}
