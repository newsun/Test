package com.symbio.sbtm.dao;

import java.util.ArrayList;

import com.symbio.sbtm.vo.Role;

public interface IUserGroup {
	public void doCreate(Role userGroup) throws Exception;

	public void doDelete(Role userGroup) throws Exception;

	public void doUpdate(Role userGroup) throws Exception;

	public Role getOS(Role userGroup) throws Exception;

	public ArrayList<Role> getAlluserGroup() throws Exception;
}
