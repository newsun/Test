package com.symbio.sbtm.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.symbio.sbtm.dbo.IDBO;
import com.symbio.sbtm.dao.IProject;
import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.utils.util;
import com.symbio.sbtm.vo.Project;
import com.symbio.sbtm.vo.User;

public class ProjectImpl implements IProject {
	private IDBO dbo = DAOFactory.getDataBaseOperator();

	public boolean doCreate(Project project) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean doDelete(Project project) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Project> getProject(Project project) throws Exception {
		// TODO Auto-generated method stub
		if (null == project)
			return null;
		String sqlcmd = "select id,name,description,createtime,creatorId from project";
		Map<String, String> map = util
				.getNonEmptyFields(Project.class, project);
		String sqlcmd_ = util.getAfterSqlCmd(map);
		if (sqlcmd_.length() > 0)
			sqlcmd += sqlcmd_;
		else
			return null;
		ArrayList<Object> list = this.dbo.ExecuteReader(sqlcmd, null);
		return conver2Project(list);
	}

	public ArrayList<Project> getAllProjects() throws SQLException {
		ArrayList<Object> list = this.dbo.ExecuteReader(
				"select id,name,description,createtime,creatorId from project",
				null);
		return conver2Project(list);
	}

	private ArrayList<Project> conver2Project(ArrayList<Object> list) {
		if (list == null) {
			return null;
		}
		ArrayList<Project> projects = new ArrayList<Project>();
		for (int i = 0; i < list.size(); i++) {
			Object[] op = (Object[]) list.get(i);
			Project p = new Project();
			p.setId(Integer.valueOf(op[0].toString()).intValue());
			p.setName(op[1].toString());
			p.setDescription(op[2].toString());
			p.setDate(op[3].toString());
			User user = new User();
			user.setUserId(op[4].toString());
			p.setCreator(user);
			projects.add(p);
		}
		return projects;
	}

	public boolean doUpdate(Project project) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
