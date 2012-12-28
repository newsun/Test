package com.symbio.sbtm.dao.impl;

import java.util.ArrayList;
import java.util.Map;

import com.symbio.sbtm.dbo.IDBO;
import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.utils.util;
import com.symbio.sbtm.vo.Area;
import com.symbio.sbtm.vo.Charter_Area;
import com.symbio.sbtm.vo.Charter;

public class AreasImpl implements com.symbio.sbtm.dao.IAreas {
	private IDBO dbo = DAOFactory.getDataBaseOperator();

	public void doCreate(Charter_Area areas) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doDelete(Charter_Area areas) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doUpdate(Charter_Area areas) throws Exception {
		// TODO Auto-generated method stub

	}

	public ArrayList<Charter_Area> getAreas(Charter_Area areas) throws Exception {
		return (ArrayList<Charter_Area>) util.getAllObjects(Charter_Area.class, Charter_Area.class,
				areas);
	}

	public ArrayList<Charter_Area> getAllAreas(Charter charter) throws Exception {
		return (ArrayList<Charter_Area>) util.getAllObjects(Charter_Area.class,
				Charter.class, charter);
	}

	private ArrayList<Charter_Area> getAllAreas(Object obj) throws Exception {
		if (null == obj)
			return null;
		String sqlcmd = "select id,charterId,areaId from areas";

		Map<String, String> map;
		if (obj instanceof Charter_Area)
			map = util.getNonEmptyFields(Charter_Area.class, obj);
		else if (obj instanceof Charter)
			map = util.getNonEmptyFields(Charter.class, obj);
		else
			return null;
		String sqlcmd_ = util.getAfterSqlCmd(map);
		if (sqlcmd_.length() > 0)
			sqlcmd += sqlcmd_;
		else
			return null;
		ArrayList<Object> list = this.dbo.ExecuteReader(sqlcmd, null);
		return convert2Areas(list);
	}

	private ArrayList<Charter_Area> convert2Areas(ArrayList<Object> list) {
		if (null == list)
			return null;
		ArrayList<Charter_Area> areass = new ArrayList<Charter_Area>();
		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			if (obj instanceof Object[]) {
				Object[] ob = (Object[]) obj;
				Charter_Area areas = new Charter_Area();
				areas.setId(Integer.valueOf(ob[0].toString()).intValue());
				Charter charter = new Charter();
				charter.setId(Integer.valueOf(ob[1].toString()));
				areas.setCharter(charter);
				Area area = new Area();
				area.setId(Integer.valueOf(ob[2].toString()));
				areas.setArea(area);
				areass.add(areas);
			}
		}
		return areass;
	}
}
