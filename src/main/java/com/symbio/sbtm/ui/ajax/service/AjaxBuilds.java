package com.symbio.sbtm.ui.ajax.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.model.Build;
import com.symbio.sbtm.model.Project;

public class AjaxBuilds {
	private Map<Integer, String> buildList;
	private Project project;

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

	public String execute() {
		try {
			ArrayList<Build> buildsArray = DAOFactory.getBuildDAO()
					.getAllbuilds(this.project);
			buildList = new TreeMap<Integer, String>();
			for (Build build : buildsArray) {
				buildList.put(Integer.valueOf(build.getId()), build.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
}
