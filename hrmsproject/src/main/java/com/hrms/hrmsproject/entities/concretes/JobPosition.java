package com.hrms.hrmsproject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import javax.persistence.Table;

@Entity
@Table(name = "job_positions")
@Data
public class JobPosition {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "title")
	private String title;

	public JobPosition() {
	}

	public JobPosition(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

}
