package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.*;

public interface BuildDao {
	public void save(Build build);

	public void delete(Build build);

	public void update(Build build);

	public Build getBuildByName(Project project, String buildName);

	public List<Build> getAllBuilds(Project project);
}
