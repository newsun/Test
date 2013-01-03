package com.symbio.sbtm.model.service;

import java.util.List;

import com.symbio.sbtm.model.OS;

public interface OSService {
	public void save(OS os) ;

	public void delete(OS os) ;

	public void update(OS os) ;

	public OS getOSbyName(String name) ;

	public List<OS> getAllOS() ;
}
