package com.auth.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

	@Id
	@Column(name = "USERNAME", length = 50, unique = true)
	@NotNull
	private String username;

	@Column(name = "PASSWORD", length = 100)
	@NotNull
	private String password;

	@Column(name = "ENABLED")
	@NotNull
	private Boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USERS_AUTHORITIES", joinColumns = {
			@JoinColumn(name = "USER_USERNAME", referencedColumnName = "USERNAME") }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID") })
	private List<Authority> authorities;

}