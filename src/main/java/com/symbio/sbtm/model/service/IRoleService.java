package com.symbio.sbtm.model.service;

import java.util.List;

import com.symbio.sbtm.model.Role;
import com.symbio.sbtm.model.User;

public interface IRoleService {
	public void save(Role role) throws Exception;

	public void delete(Role role) throws Exception;

	public void update(Role role) throws Exception;

	public Role getRoleByName(String name) throws Exception;

	public List<User> getAllUserByRoleId(String userId) throws Exception;
}
