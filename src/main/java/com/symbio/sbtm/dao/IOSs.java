package com.symbio.sbtm.dao;

import java.util.ArrayList;

import com.symbio.sbtm.vo.Charter;
import com.symbio.sbtm.vo.OSs;

public interface IOSs {
	public void doCreate(OSs os) throws Exception;

	public void doDelete(OSs os) throws Exception;

	public void doUpdate(OSs os) throws Exception;

	public ArrayList<OSs> getOSs(OSs os) throws Exception;

	public ArrayList<OSs> getOSs(Charter charter) throws Exception;

	public ArrayList<OSs> getAllOSs() throws Exception;
}
