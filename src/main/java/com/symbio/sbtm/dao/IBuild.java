package com.symbio.sbtm.dao;

import java.util.ArrayList;

import com.symbio.sbtm.vo.Build;
import com.symbio.sbtm.vo.Project;

public interface IBuild {
	public void doCreate(Build build) throws Exception;

	public void doDelete(Build build) throws Exception;

	public void doUpdate(Build build) throws Exception;

	public ArrayList<Build> getBuild(Build build) throws Exception;

	public ArrayList<Build> getAllbuilds(Project project) throws Exception;
}
