package com.symbio.sbtm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Role {
	@Id
	@GeneratedValue(generator="increment")
	@Column(name = "id", length = 20)
	private long id;

	@Column(name = "name", length = 50, unique = true, nullable = false)
	private String name;

	@Column(name = "description", length = 250)
	private String description;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Role_User", joinColumns = { @JoinColumn(name = "roleId") }, inverseJoinColumns = { @JoinColumn(name = "userId") })
	private List<User> users = new ArrayList<User>();

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
