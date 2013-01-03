package com.symbio.sbtm.ui.ajax.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.opensymphony.xwork2.ActionSupport;
import com.symbio.sbtm.model.Build;
import com.symbio.sbtm.model.Project;
import com.symbio.sbtm.model.service.BuildService;
import com.symbio.sbtm.model.service.ProjectService;

public class AjaxBuilds extends ActionSupport {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	private transient ProjectService projectService;
	private transient BuildService buildService;
	private Map<Integer, String> buildList;
	private Project project;

	public String execute() {
		try {
			if (null == project)
				return "Input";
			project = projectService.getProject(project);
			List<Build> builds = buildService.getAllBuilds(project);
			buildList = new TreeMap<Integer, String>();
			for (Build build : builds) {
				buildList.put(build.getId().intValue(), build.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
		return "success";
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setBuildService(BuildService buildService) {
		this.buildService = buildService;
	}

	public Map<Integer, String> getBuildList() {
		return buildList;
	}

	public void setBuildList(Map<Integer, String> buildList) {
		this.buildList = buildList;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
