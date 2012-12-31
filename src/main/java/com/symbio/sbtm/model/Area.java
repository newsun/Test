package com.symbio.sbtm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

//@Entity
public class Area implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id", length = 20)
	private long id;

	@Column(name = "name", length = 50)
	private String name;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "parentId")
	private Area parent;

	@OneToMany(mappedBy = "parent")
	private List<Area> subAreas = new ArrayList<Area>();

	@Column(name = "description", length = 250)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "projectId")
	private Project project;

	@Column(name = "buildId", length = 50)
	private Build build;

	public Area() {
	}

	public Area(String name, Project project) {
		this.name = name;
		this.project = project;
	}

	public Build getBuild() {
		return build;
	}

	public void setBuild(Build build) {
		this.build = build;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Area> getSubAreas() {
		return subAreas;
	}

	public void setSubAreas(List<Area> subAreas) {
		this.subAreas = subAreas;
	}

	public Area getParent() {
		return parent;
	}

	public void setParent(Area parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
