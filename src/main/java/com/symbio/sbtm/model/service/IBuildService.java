package com.symbio.sbtm.model.service;

import java.util.List;

import com.symbio.sbtm.model.Build;

public interface IBuildService {
	public void save(Build build) throws Exception;

	public void delete(Build build) throws Exception;

	public void update(Build build) throws Exception;

	public Build getBuildByName(String name) throws Exception;
	
	public List<Build> getAllBuilds() throws Exception;
}
