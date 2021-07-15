package com.hrms.hrmsproject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "system_users")
@Data
public class SystemUser {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;

	public SystemUser() {
	}

	public SystemUser(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
