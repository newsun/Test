package com.symbio.sbtm.model.dao;

import java.util.ArrayList;

import com.symbio.sbtm.model.Build;
import com.symbio.sbtm.model.Project;

public interface IBuild {
	public void doCreate(Build build) throws Exception;

	public void doDelete(Build build) throws Exception;

	public void doUpdate(Build build) throws Exception;

	public ArrayList<Build> getBuild(Build build) throws Exception;

	public ArrayList<Build> getAllbuilds(Project project) throws Exception;
}
