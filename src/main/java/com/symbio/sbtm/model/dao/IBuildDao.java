package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.*;

public interface IBuildDao {
	public void save(Build build) throws Exception;

	public void delete(Build build) throws Exception;

	public void update(Build build) throws Exception;

	public Build getBuildByName(Project project, String buildName) throws Exception;

	public List<Build> getAllBuilds(Project project) throws Exception;
}
