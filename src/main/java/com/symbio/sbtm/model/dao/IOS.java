package com.symbio.sbtm.model.dao;

import java.util.ArrayList;

import com.symbio.sbtm.model.OS;

public interface IOS {
	public void doCreate(OS os) throws Exception;

	public void doDelete(OS os) throws Exception;

	public void doUpdate(OS os) throws Exception;

	public ArrayList<OS> getOS(OS os) throws Exception;

	public ArrayList<OS> getAllOSs() throws Exception;
}
