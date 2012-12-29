package com.symbio.sbtm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(generator="increment")
	@Column(name = "id", length = 20)
	private long id;

	@Column(name = "userId", length = 50, nullable = false, unique = true)
	private String userId;

	@Column(name = "password", length = 50, nullable = false)
	private String password;

	@Column(name = "firstName", length = 50)
	private String firstName;

	@Column(name = "lastName", length = 50)
	private String lastName;

	@Column(name = "valid")
	private boolean valid = true;

	@Column(name = "description", length = 250)
	private String description;

	@ManyToMany(mappedBy = "users")
	private List<Role> roles = new ArrayList<Role>();

	public User() {
	}

	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return this.userId;
	}
}