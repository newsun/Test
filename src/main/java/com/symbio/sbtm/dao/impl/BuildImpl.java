package com.symbio.sbtm.dao.impl;

import java.util.ArrayList;
import java.util.Map;

import com.symbio.sbtm.dao.IBuild;
import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.utils.util;
import com.symbio.sbtm.vo.Build;
import com.symbio.sbtm.vo.Project;

public class BuildImpl implements IBuild {

	public void doCreate(Build build) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doDelete(Build build) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doUpdate(Build build) throws Exception {
		// TODO Auto-generated method stub

	}

	public ArrayList<Build> getBuild(Build build) throws Exception {
		return getAllBuilds(Build.class, build);
	}

	public ArrayList<Build> getAllbuilds(Project project) throws Exception {
		return getAllBuilds(Project.class, project);
	}

	private ArrayList<Build> getAllBuilds(Class<?> cl, Object obj)
			throws Exception {
//		return (ArrayList<Build>) util.getAllObjects(Build.class, cl, obj);
		String sqlcmd = util.getSqlCmd(Build.class, cl, obj);
		ArrayList<Object> list = DAOFactory.getDataBaseOperator()
				.ExecuteReader(sqlcmd, null);
		return convert2Build(list);
	}

	private ArrayList<Build> convert2Build(ArrayList<Object> list) {
		if (null == list)
			return null;
		ArrayList<Build> builds = new ArrayList<Build>();
		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			if (obj instanceof Object[]) {
				Object[] ob = (Object[]) obj;
				Build build = new Build();
				build.setId(Integer.valueOf(ob[0].toString()).intValue());
				build.setName(ob[1].toString());
				build.setDescription(ob[2].toString());
				Project project = new Project();
				project.setId(Integer.valueOf(ob[3].toString()).intValue());
				build.setProject(project);
				builds.add(build);
			}
		}
		return builds;
	}

	public static void main(String[] args) throws Exception {
		Project project = new Project();
		project.setId(1);
		Build build = new Build();
		build.setId(2);
		build.setProject(project);
		ArrayList builds = new BuildImpl().getBuild(build);
		new BuildImpl().getAllbuilds(project);
	}
}
