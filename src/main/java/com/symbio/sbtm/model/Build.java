package com.symbio.sbtm.model;

import java.io.Serializable;

import javax.persistence.*;

//@Entity
public class Build implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id", length = 20)
	private int id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "description", length = 250)
	private String description;
	
	@Column(name = "description", length = 250)
	private Project project;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(this.id);
	}

}
