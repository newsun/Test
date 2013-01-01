package com.symbio.sbtm.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Build implements Serializable {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "projectId")
	private Project project;

	@Id
	@Size(min = 2, max = 50, message = "Build name must be between 2-50")
	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "description", length = 255)
	private String description;

	public Build() {
	}

	public Build(String name, Project project) {
		this.name = name;
		this.project = project;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
