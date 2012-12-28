package com.symbio.sbtm.dao;

import java.util.ArrayList;

import com.symbio.sbtm.model.Project;

public interface IProject {
	public boolean doCreate(Project project) throws Exception;

	public boolean doDelete(Project project) throws Exception;

	public boolean doUpdate(Project project) throws Exception;

	public ArrayList<Project> getProject(Project project) throws Exception;

	public ArrayList<Project> getAllProjects() throws Exception;
}
