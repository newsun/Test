package com.symbio.sbtm.model.dao;

import java.util.ArrayList;

import com.symbio.sbtm.model.Bug;
import com.symbio.sbtm.model.Charter;

public interface IBug {
	public void doCreate(Bug bug) throws Exception;

	public void doDelete(Bug bug) throws Exception;

	public void doUpdate(Bug bug) throws Exception;

	public ArrayList<Bug> getBug(Bug bug) throws Exception;

	public ArrayList<Bug> getAllBugs(Charter charter) throws Exception;
}
