package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.*;

public interface IAreaDao {

	public void save(Area area) throws Exception;

	public void delete(Area area) throws Exception;

	public void update(Area area) throws Exception;

	public Area getAreaByName(Project project, String name) throws Exception;

	public Area getAreaByName(Build build, String name) throws Exception;

	public List<Area> getAllAreaInBuild(Build build) throws Exception;

	public List<Area> getAllAreaInProject(Project project) throws Exception;

	Area getAreaById(Long id) throws Exception;
}
