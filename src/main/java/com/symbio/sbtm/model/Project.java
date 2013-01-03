package com.symbio.sbtm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Project implements Serializable {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Size(min = 4, max = 50, message = "Project name must be between 4-50")
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "createtime")
	@GeneratedValue
	private Date date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "creatorId")
	private User creator;

	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
	private Set<Build> builds = new HashSet<Build>();

	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
	private Set<Area> areas = new HashSet<Area>();

	public Project() {
	}

	public Project(String name, User user) {
		this.name = name;
		this.creator = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Set<Build> getBuilds() {
		return builds;
	}

	public void setBuilds(Set<Build> builds) {
		this.builds = builds;
	}

	public Set<Area> getAreas() {
		return areas;
	}

	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		// result = prime * result + ((creator == null) ? 0 : creator.hashCode());
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

		Project other = (Project) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		// if (creator == null) {
		// if (other.creator != null)
		// return false;
		// } else if (!creator.equals(other.creator))
		// return false;
		return true;
	}
}
