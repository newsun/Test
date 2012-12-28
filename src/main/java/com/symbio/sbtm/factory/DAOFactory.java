package com.symbio.sbtm.factory;

import com.symbio.sbtm.dao.impl.proxy.AreaProxy;
import com.symbio.sbtm.dao.impl.proxy.AreasProxy;
import com.symbio.sbtm.dao.impl.proxy.BuildProxy;
import com.symbio.sbtm.dao.impl.proxy.CharterProxy;
import com.symbio.sbtm.dao.impl.proxy.DurationProxy;
import com.symbio.sbtm.dao.impl.proxy.ProjectProxy;
import com.symbio.sbtm.dao.impl.proxy.UserProxy;
import com.symbio.sbtm.dbo.IDBO;
import com.symbio.sbtm.dbo.MySqlDBOperator;

public class DAOFactory {
	private static MySqlDBOperator mysql = null;

	public static UserProxy getUserDAO() {
		return new UserProxy();
	}

	public static IDBO getDataBaseOperator() {
		if (mysql == null)
			mysql = new MySqlDBOperator();
		return mysql;
	}

	private static ProjectProxy pp;

	public static ProjectProxy getProjectDAO() {
		if (null == pp)
			pp = new ProjectProxy();
		return pp;
	}

	private static AreaProxy arp;

	public static AreaProxy getAreaDAO() {
		if (arp == null)
			arp = new AreaProxy();
		return arp;
	}

	private static AreasProxy arsp;

	public static AreasProxy getAreasDAO() {
		if (arsp == null)
			arsp = new AreasProxy();
		return arsp;
	}

	private static BuildProxy bp;

	public static BuildProxy getBuildDAO() {
		if (null == bp)
			bp = new BuildProxy();
		return bp;
	}

	private static CharterProxy chp;

	public static CharterProxy getCharterDAO() {
		if (chp == null)
			chp = new CharterProxy();
		return chp;
	}

	private static DurationProxy dp;

	public static DurationProxy getDurationProxy() {
		if (null == dp)
			dp = new DurationProxy();
		return dp;
	}
}
