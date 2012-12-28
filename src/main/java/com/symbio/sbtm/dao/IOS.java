package com.symbio.sbtm.dao;

import java.util.ArrayList;

import com.symbio.sbtm.vo.OS;

public interface IOS {
	public void doCreate(OS os) throws Exception;

	public void doDelete(OS os) throws Exception;

	public void doUpdate(OS os) throws Exception;

	public ArrayList<OS> getOS(OS os) throws Exception;

	public ArrayList<OS> getAllOSs() throws Exception;
}
