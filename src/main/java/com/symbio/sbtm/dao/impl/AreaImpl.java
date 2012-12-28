package com.symbio.sbtm.dao.impl;

import java.util.ArrayList;
import java.util.Map;

import com.symbio.sbtm.dao.IArea;
import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.utils.util;
import com.symbio.sbtm.vo.Area;
import com.symbio.sbtm.vo.Build;
import com.symbio.sbtm.vo.Project;

public class AreaImpl implements IArea {

	public void doCreate(Area area) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doDelete(Area area) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doUpdate(Area area) throws Exception {
		// TODO Auto-generated method stub

	}

	public ArrayList<Area> getArea(Area area) throws Exception {
		if (null == area) {
			return null;
		}
		String sqlcmd = "select id,	name,parentId,isleaf,description,projectId,buildId from area";
		Map<String, String> map = util.getNonEmptyFields(Area.class, area);
		String sqlcmd_ = util.getAfterSqlCmd(map);
		if (sqlcmd_.length() > 0)
			sqlcmd += sqlcmd_;
		else
			return null;
		ArrayList<Object> list = DAOFactory.getDataBaseOperator()
				.ExecuteReader(sqlcmd, null);
		return convert2Area(list);
	}

	// public ArrayList<Area> getAllAreas() throws Exception {
	// return getAllAreas(null, null);
	// }

	public ArrayList<Area> getAllAreas(Project project) throws Exception {
		return getAllAreas(project, null);
	}

	public ArrayList<Area> getAllAreas(Build Build) throws Exception {
		return getAllAreas(null, Build);
	}

	public ArrayList<Area> getAllAreas(Project project, Build build)
			throws Exception {
		String sqlcmd = "select id,	name,parentId,isleaf,description,projectId,buildId from area";
		boolean p = project != null && project.getId() > 0;
		boolean b = build != null && build.getId() > 0;
		if (p && b) {
			if (build.getProject().getId() != project.getId())
				throw new Exception("Wrong build id and project Id");
			sqlcmd += " where projectdId=" + project.getId() + " and buildId="
					+ build.getId();
		} else if (p && !b) {
			sqlcmd += " where projectdId=" + project.getId();
		} else if (!p && b) {
			sqlcmd += " where buildId=" + build.getId();
		} else {
			return null;
		}
		ArrayList<Object> list = DAOFactory.getDataBaseOperator()
				.ExecuteReader(sqlcmd, null);
		return convert2Area(list);
	}

	private ArrayList<Area> convert2Area(ArrayList<Object> list) {
		if (list == null) {
			return null;
		}
		ArrayList<Area> areas = new ArrayList<Area>();
		for (int i = 0; i < list.size(); i++) {
			Object[] op = (Object[]) list.get(i);
			Area s = new Area();
			s.setId(Integer.valueOf(op[0].toString()).intValue());
			s.setName(op[1].toString());
			// s.setParentId(Integer.valueOf(op[2].toString()));
			// s.setIsleaf(Boolean.getBoolean(op[3].toString()));
			s.setDescription(op[4].toString());
			Project pp = new Project();
			pp.setId(Integer.valueOf(op[5].toString()).intValue());
			s.setProject(pp);
			Build bb = new Build();
			bb.setId(Integer.valueOf(op[6].toString()));
			s.setBuild(bb);
			areas.add(s);
		}
		return areas;
	}
}
