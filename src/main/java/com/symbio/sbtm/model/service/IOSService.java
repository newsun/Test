package com.symbio.sbtm.model.service;

import java.util.List;

import com.symbio.sbtm.model.OS;

public interface IOSService {
	public void save(OS os) throws Exception;

	public void delete(OS os) throws Exception;

	public void update(OS os) throws Exception;

	public OS getOSbyName(String name) throws Exception;

	public List<OS> getAllOS() throws Exception;
}
