package com.symbio.sbtm.dao.impl;

import java.util.ArrayList;

import com.symbio.sbtm.dao.IOSs;
import com.symbio.sbtm.utils.util;
import com.symbio.sbtm.vo.Charter;
import com.symbio.sbtm.vo.OSs;

public class OSsImpl implements IOSs {

	public void doCreate(OSs os) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doDelete(OSs os) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doUpdate(OSs os) throws Exception {
		// TODO Auto-generated method stub

	}

	public ArrayList<OSs> getOSs(OSs os) throws Exception {
		// TODO Auto-generated method stub
		if (os == null)
			return null;
		// String sqlcmd = util.getSqlCmd(OSs.class, OSs.class, os);
		ArrayList<OSs> oss = (ArrayList<OSs>) util.getAllObjects(OSs.class,
				OSs.class, os);
		return oss;
	}

	public ArrayList<OSs> getAllOSs() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<OSs> oss = (ArrayList<OSs>) util.getAllObjects(OSs.class,
				null, null);
		return oss;
	}

	public ArrayList<OSs> getOSs(Charter charter) throws Exception {
		// TODO Auto-generated method stub
		if (charter == null)
			return null;
		// String sqlcmd = util.getSqlCmd(OSs.class, OSs.class, os);
		ArrayList<OSs> oss = (ArrayList<OSs>) util.getAllObjects(OSs.class,
				Charter.class, charter);
		return oss;
	}

}
