package com.auth.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "ID", length = 11, unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "USERNAME", length = 64, unique = true)
	@NotNull
	private String username;
	
	@Column(name = "NAME", length = 64)
	@NotNull
	private String name;
	
	@Column(name = "SURNAME", length = 64)
	@NotNull
	private String surname;
	
	@Column(name = "EMAIL", length = 150)
	@NotNull
	private String email;
	
	@Column(name = "DATE_OF_BIRTH")
	@NotNull
	private Date dateOfBirth;
	
	@Column(name = "SEX")
	private SexType sex;
	
	@Column(name = "COUNTRY", length = 64)
	private String country;
	
	@Column(name = "CITY", length = 64)
	private String city;
	
	@Column(name = "PASSWORD", length = 64)
	private String password;
	
	@Column(name = "OLD_PASSWORD", length = 64)
	private String oldPassword;
	
	@Column(name = "PASSOWORD_ATTEMPTS")
	private Integer passwordAttempts;
	
	@Column(name = "ENABLED")
	@NotNull
	private Boolean enabled;
	
	@Column(name = "INSCRIPTION_DATE")
	@NotNull
	private Date inscriptionDate;
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ROLE", joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") })
	private List<Role> roles;

}