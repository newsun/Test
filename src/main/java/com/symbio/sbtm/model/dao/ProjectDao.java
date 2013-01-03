package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.Project;

public interface ProjectDao {
	public void save(Project project);

	public void delete(Project project);

	public void update(Project project);

	public Project getProjectByName(String name);

	public Project getProject(Project project);

	public Project getProjectById(Long projectId);

	public List<Project> getAllProjects();

}
