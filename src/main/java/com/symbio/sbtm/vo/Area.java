package com.symbio.sbtm.vo;

import java.util.List;

import javax.persistence.*;

@Entity
public class Area {
	@Id
	@GeneratedValue
	@Column(name = "id", length = 20)
	private int id;

	@Column(name = "name", length = 50)
	private String name;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "parentId")
	private Area parent;

	@OneToMany(mappedBy = "parentId")
	private List<Area> subAreas;

	@Column(name = "description", length = 50)
	private String description;

	@Column(name = "projectId", length = 50)
	private Project project;

	@Column(name = "buildId", length = 50)
	private Build build;

	public Area() {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
