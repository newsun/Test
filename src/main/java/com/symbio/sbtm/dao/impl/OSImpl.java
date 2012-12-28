package com.symbio.sbtm.dao.impl;

import java.util.ArrayList;

import com.symbio.sbtm.dao.IOS;
import com.symbio.sbtm.dao.IOSs;
import com.symbio.sbtm.utils.util;
import com.symbio.sbtm.vo.Charter;
import com.symbio.sbtm.vo.OS;
import com.symbio.sbtm.vo.OSs;

public class OSImpl implements IOS {

	public void doCreate(OS os) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doDelete(OS os) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doUpdate(OS os) throws Exception {
		// TODO Auto-generated method stub

	}

	public ArrayList<OS> getAllOSs() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OS> getOS(OS os) throws Exception {
		// TODO Auto-generated method stub
		if (null == os)
			return null;
		return (ArrayList<OS>) util.getAllObjects(OS.class, OS.class, os);
	}
}
