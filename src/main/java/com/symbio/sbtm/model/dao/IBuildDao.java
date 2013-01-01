package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.Build;

public interface IBuildDao {
	public void save(Build build) throws Exception;

	public void delete(Build build) throws Exception;

	public void update(Build build) throws Exception;

	public Build getBuildByName(String name) throws Exception;
	
	public List<Build> getAllBuilds() throws Exception;
}
