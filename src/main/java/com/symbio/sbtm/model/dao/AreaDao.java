package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.*;

public interface AreaDao {

	public void save(Area area);

	public void delete(Area area);

	public void update(Area area);

	public Area getAreaByName(Project project, String name);

	public Area getAreaByName(Build build, String name);

	public List<Area> getAllAreaInBuild(Build build);

	public List<Area> getAllAreaInProject(Project project);

	Area getAreaById(Long id);
}
