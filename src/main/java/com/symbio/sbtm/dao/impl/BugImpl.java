package com.symbio.sbtm.dao.impl;

import java.util.ArrayList;
import java.util.Map;

import com.symbio.sbtm.dao.IBug;
import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.utils.util;
import com.symbio.sbtm.vo.Bug;
import com.symbio.sbtm.vo.Charter;

public class BugImpl implements IBug {

	public void doCreate(Bug bug) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doDelete(Bug bug) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doUpdate(Bug bug) throws Exception {
		// TODO Auto-generated method stub

	}

	public ArrayList<Bug> getAllBugs(Charter charter) throws Exception {
		return getAllObject(charter);
	}

	public ArrayList<Bug> getBug(Bug bug) throws Exception {
		return getAllObject(bug);
	}

	public ArrayList<Bug> getAllObject(Object obj) throws Exception {
		if (obj == null)
			return null;
		String sqlcmd = "select id,summary,description,charterId from bug";

		if (obj instanceof Bug) {
			Map<String, String> map = util.getNonEmptyFields(Bug.class, obj);
			sqlcmd += util.getAfterSqlCmd(map);
		} else if (obj instanceof Charter)
			sqlcmd += " where charterId=" + ((Charter) obj).getId();
		else
			return null;

		ArrayList<Object> list = DAOFactory.getDataBaseOperator()
				.ExecuteReader(sqlcmd, null);
		
		return convert2Bug(list);
	}

	private ArrayList<Bug> convert2Bug(ArrayList<Object> list) {
		if (null == list)
			return null;
		ArrayList<Bug> bugs = new ArrayList<Bug>();
		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			if (obj instanceof Object[]) {
				Object[] ob = (Object[]) obj;
				Bug bug = new Bug();
				bug.setId(ob[0].toString());
				bug.setSummary(ob[1].toString());
				bug.setDescription(ob[2].toString());
				Charter charter = new Charter();
				charter.setId(Integer.valueOf(ob[3].toString()).intValue());
				bug.setCharter(charter);
				bugs.add(bug);
			}
		}
		return bugs;
	}

}
