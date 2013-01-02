package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.Role;

public interface IRoleDao {
	public void save(Role role) throws Exception;

	public void delete(Role role) throws Exception;

	public void update(Role role) throws Exception;

	public Role getRoleByName(String name) throws Exception;

	public List<Role> getAllRoles() throws Exception;
}
