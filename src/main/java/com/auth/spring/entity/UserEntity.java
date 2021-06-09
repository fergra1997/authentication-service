package com.auth.spring.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USER")
@Data
public class UserEntity {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "AGE")
	private Integer age;

	@Column(name = "SEX")
	private String sex;

	@Column(name = "NUMBER")
	private String telephoneNumber;

	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

}
