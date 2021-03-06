package com.symbio.sbtm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import javax.validation.constraints.Size;

@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6097128657699586225L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Size(min = 4, max = 50, message = "user name must be between 4-50")
	@Column(name = "userId", length = 50, nullable = false, unique = true)
	private String userId;

	@Column(name = "password", length = 50, nullable = false)
	private String password;

	@Size(min = 4, max = 50, message = "password must be between 5-50")
	@Column(name = "firstName", length = 50)
	private String firstName;

	@Column(name = "lastName", length = 50)
	private String lastName;

	@Column(name = "valid")
	private boolean valid = true;

	@Column(name = "description", length = 250)
	private String description;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<Role> roles = new HashSet<Role>();

	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
	private Set<Project> createdProjects = new HashSet<Project>();

	@OneToMany(mappedBy = "tester", fetch = FetchType.LAZY)
	private Set<Charter> charters = new HashSet<Charter>();

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Project> getCreatedProjects() {
		return createdProjects;
	}

	public void setCreatedProjects(Set<Project> createdProjects) {
		this.createdProjects = createdProjects;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Charter> getCharters() {
		return charters;
	}

	public void setCharters(Set<Charter> charters) {
		this.charters = charters;
	}

	@Override
	public String toString() {
		return this.userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());

		result = prime * result + ((userId == null) ? 0 : userId.hashCode());

		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());

		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;

		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;

		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;

		// Set<Role> otherroles = other.getRoles();
		// if (roles.size() != otherroles.size())
		// return false;
		// for (Iterator<Role> it = roles.iterator(); it.hasNext();) {
		// if (!otherroles.contains(it))
		// return false;
		// }
		return true;
	}
}
