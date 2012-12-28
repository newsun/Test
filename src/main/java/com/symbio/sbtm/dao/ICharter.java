package com.symbio.sbtm.dao;

import java.util.ArrayList;

import com.symbio.sbtm.vo.Area;
import com.symbio.sbtm.vo.Build;
import com.symbio.sbtm.vo.Charter;
import com.symbio.sbtm.vo.Project;

public interface ICharter {
	public void doCreate(Charter charter) throws Exception;

	public void doDelete(Charter charter) throws Exception;

	public void doUpdate(Charter charter) throws Exception;

	public ArrayList<Charter> getCharter(Charter charter) throws Exception;

	public ArrayList<Charter> getAllCharters(Build build) throws Exception;

	public ArrayList<Charter> getAllCharters(Project project) throws Exception;

	public ArrayList<Charter> getAllCharters(Area area) throws Exception;
}
