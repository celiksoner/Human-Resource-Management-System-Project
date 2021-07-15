package com.hrms.hrmsproject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "employers")
@Data
public class Employer {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String website;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	public Employer() {
	}

	public Employer(int id, String companyName, String website, String phoneNumber, String email) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.website = website;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

}
