package com.symbio.sbtm.model.service;

import java.util.List;

import com.symbio.sbtm.model.Project;

public interface IProjectService {
	public void save(Project project);

	public void delete(Project project);

	public void update(Project project);

	public Project getProjectByName(String name);

	public List<Project> getAllProjects();
}
