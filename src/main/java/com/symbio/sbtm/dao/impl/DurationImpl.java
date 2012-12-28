package com.symbio.sbtm.dao.impl;

import java.util.ArrayList;

import com.symbio.sbtm.dao.IDuration;
import com.symbio.sbtm.dbo.IDBO;
import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.vo.Duration;

public class DurationImpl implements IDuration {
	private IDBO dbo = DAOFactory.getDataBaseOperator();

	public void doCreate(Duration duration) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doDelete(Duration duration) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doUpdate(Duration duration) throws Exception {
		// TODO Auto-generated method stub

	}

	public ArrayList<Duration> getDuration(Duration duration) throws Exception {
		String sqlcmd = "Select name,timespan,description from duration";

		ArrayList<Object> list = this.dbo.ExecuteReader(sqlcmd, null);
		return convert2Duration(list);

	}

	public ArrayList<Duration> getAllDurations() throws Exception {
		// TODO Auto-generated method stub
		String sqlcmd = "Select name,timespan,description from duration";

		ArrayList<Object> list = this.dbo.ExecuteReader(sqlcmd, null);
		return convert2Duration(list);
	}

	private ArrayList<Duration> convert2Duration(ArrayList<Object> list) {
		if (null == list)
			return null;
		ArrayList<Duration> durations = new ArrayList<Duration>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Object[]) {
				Object[] obj = (Object[]) list.get(i);
				Duration du = new Duration();
				du.setName(obj[0].toString());
				du.setTimespan(Integer.valueOf(obj[1].toString()));
				du.setDescription(obj[2].toString());
				durations.add(du);
			}
		}
		return durations;
	}
}
