package com.symbio.sbtm.model.service;

import java.util.List;

import com.symbio.sbtm.model.Project;

public interface IProjectService {
	public void save(Project project) throws Exception;

	public void delete(Project project) throws Exception;

	public void update(Project project) throws Exception;

	public Project getProjectByName(String name) throws Exception;

	public List<Project> getAllProjects() throws Exception;
}
