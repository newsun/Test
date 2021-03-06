package com.symbio.sbtm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "name", "projectId" }))
public class Area implements Serializable {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Size(min = 4, max = 50, message = "Area name must be between 4-50")
	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "parentId")
	private Area parent;

	@OneToMany(mappedBy = "parent")
	private Set<Area> subAreas = new HashSet<Area>();

	@Column(name = "description", length = 255)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId")
	private Project project;

	@ManyToMany(mappedBy = "areas", fetch = FetchType.LAZY)
	private Set<Build> builds = new HashSet<Build>();

	@ManyToMany(mappedBy = "areas", fetch = FetchType.LAZY)
	private Set<Charter> charters = new HashSet<Charter>();

	public Area() {
	}

	public Area(String name, Project project) {
		this.name = name;
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Area> getSubAreas() {
		return subAreas;
	}

	public void setSubAreas(Set<Area> subAreas) {
		this.subAreas = subAreas;
	}

	public Area getParent() {
		return parent;
	}

	public void setParent(Area parent) {
		this.parent = parent;
	}

	public Set<Build> getBuilds() {
		return builds;
	}

	public void setBuilds(Set<Build> builds) {
		this.builds = builds;
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
		return this.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		// result = prime * result + ((project == null) ? 0 : project.hashCode());
		// result = prime * result + ((parent == null) ? 0 : parent.hashCode());
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

		Area other = (Area) obj;
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

		// if (project == null) {
		// if (other.project != null)
		// return false;
		// } else if (!project.equals(other.project))
		// return false;
		//
		// if (parent == null) {
		// if (other.parent != null)
		// return false;
		// } else if (!parent.equals(other.parent))
		// return false;
		return true;
	}
}
