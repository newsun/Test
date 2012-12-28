package com.symbio.sbtm.dao.impl;

import java.util.ArrayList;
import java.util.Map;

import com.symbio.sbtm.dao.IUser;
import com.symbio.sbtm.dbo.IDBO;
import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.utils.util;
import com.symbio.sbtm.vo.Project;
import com.symbio.sbtm.vo.User;
import com.symbio.sbtm.vo.Role;

public class UserImpl implements IUser {
	private IDBO dbo = DAOFactory.getDataBaseOperator();

	public void doUpdate(User user) throws Exception {
		// TODO Auto-generated method stub
	}

	public void doCreate(User user) throws Exception {
		// TODO Auto-generated method stub
	}

	public ArrayList<User> getAllUsers() throws Exception {
		// TODO Auto-generated method stub
		return getUser(null);
	}

	public ArrayList<User> getUser(User user) throws Exception {

		if (null == user)
			return null;
		String sqlcmd = "select userId,name,password,groupId,valid,description from user";
		Map<String, String> map = util.getNonEmptyFields(User.class, user);
		String sqlcmd_ = util.getAfterSqlCmd(map);
		if (sqlcmd_.length() > 0)
			sqlcmd += sqlcmd_;
		else
			return null;
		ArrayList<Object> list = this.dbo.ExecuteReader(sqlcmd, null);
		return convert2User(list);
	}

	private ArrayList<User> convert2User(ArrayList<Object> list) {
		if (null == list)
			return null;
		ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			if (obj instanceof Object[]) {
				User p = new User();
				Object[] initData = (Object[]) obj;
				p.setUserId(initData[0].toString());
				p.setFirstName(initData[1].toString());
				p.setPassword(initData[2].toString());
				Role ug = new Role();
				ug.setId(Integer.valueOf(initData[3].toString()).intValue());
				p.setRole(ug);
				p.setValid(Boolean.getBoolean(initData[4].toString()));
				p.setDescription(initData[5].toString());
				users.add(p);
			}
		}
		return users;
	}

	public void doDelete(User user) throws Exception {
		// TODO Auto-generated method stub
	}
}
