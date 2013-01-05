package com.symbio.sbtm.ui.ajax.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.symbio.sbtm.model.Area;
import com.symbio.sbtm.model.Build;
import com.symbio.sbtm.model.Project;
import com.symbio.sbtm.model.service.AreaService;

public class AjaxAreas extends ActionSupport {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	@Autowired
	private transient AreaService areaService;

	private Map<Integer, String> areaMap;
	private Project project;
	private Build build;

	public String execute() {
		if (areaMap == null)
			try {
				List<Area> areas = null;
				if (project != null && project.getId() > 0) {
					areas = areaService.getAllAreaInProject(project);
				} else if (build != null && build.getId() > 0) {
					areas = areaService.getAllAreaInBuild(build);
				}
				areaMap = new TreeMap<Integer, String>();
				for (Area area : areas) {
					areaMap.put(area.getId().intValue(), area.getName());
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "Error";
			}
		return "success";
	}

	public Map<Integer, String> getAreaMap() {
		return areaMap;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

}
