package com.symbio.sbtm.ui.ajax.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.symbio.sbtm.model.Project;
import com.symbio.sbtm.model.service.ProjectService;

/**
 * Servlet implementation class service1
 */

public class AjaxProjects extends ActionSupport {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient ProjectService projectService;

	private Map<Integer, String> projectsMap;

	@Override
	public String execute() {
		List<Project> projectListArray = projectService.getAllProjects();
		projectsMap = new TreeMap<Integer, String>();
		for (Project project : projectListArray) {
			projectsMap.put(project.getId().intValue(), project.getName());
		}
		return "success";
	}

	public Map<Integer, String> getProjectsMap() {
		return projectsMap;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

}
