package com.symbio.sbtm.model.service;

import java.util.List;

import com.symbio.sbtm.model.Build;
import com.symbio.sbtm.model.Project;

public interface IBuildService {
	public void save(Build build) throws Exception;

	public void delete(Build build) throws Exception;

	public void update(Build build) throws Exception;

	public Build getBuildByName(Project project, String buildName) throws Exception;

	public List<Build> getAllBuilds(Project project) throws Exception;
}
