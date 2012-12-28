package com.symbio.sbtm.ui.ajax.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.vo.Project;

/**
 * Servlet implementation class service1
 */
public class AjaxProjects {

	private Map<Integer, String> projectsMap;

	public Map<Integer, String> getProjectsMap() {
		return projectsMap;
	}

	public void setProjectMap(Map<Integer, String> projectsMap) {
		this.projectsMap = projectsMap;
	}

	public String execute() {
		try {
			ArrayList<Project> projectListArray = DAOFactory.getProjectDAO()
					.getAllProjects();
			projectsMap = new TreeMap<Integer, String>();
			for (Project project : projectListArray) {
				projectsMap.put(Integer.valueOf(project.getId()), project
						.getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
}
