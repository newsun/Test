package com.symbio.sbtm.ui.ajax.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.model.Area;
import com.symbio.sbtm.model.Build;
import com.symbio.sbtm.model.Project;

public class AjaxAreas {
	private Map<Integer, String> areaMap;
	private Project project;
	private Build build;

	public String execute() {
		if (areaMap == null)
			try {
				ArrayList<Area> AreaArray = new ArrayList<Area>();
				if (project != null && project.getId() > 0) {
					AreaArray = DAOFactory.getAreaDAO().getAllAreas(project);
				} else if (build != null && build.getId() > 0) {
					AreaArray = DAOFactory.getAreaDAO().getAllAreas(build);
				}
				areaMap = new TreeMap<Integer, String>();
				for (Area area : AreaArray) {
					areaMap.put(Integer.valueOf(area.getId()), area.getName());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "success";
	}

	public Map<Integer, String> getAreaMap() {
		return areaMap;
	}

	public void setAreaMap(Map<Integer, String> areaMap) {
		this.areaMap = areaMap;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Build getBuild() {
		return build;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

}
