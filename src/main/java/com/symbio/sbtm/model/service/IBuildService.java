package com.symbio.sbtm.model.service;

import java.util.List;

import com.symbio.sbtm.model.Build;
import com.symbio.sbtm.model.Project;

public interface IBuildService {
	public void save(Build build) ;

	public void delete(Build build) ;

	public void update(Build build) ;

	public Build getBuildByName(Project project, String buildName) ;

	public List<Build> getAllBuilds(Project project) ;
}
