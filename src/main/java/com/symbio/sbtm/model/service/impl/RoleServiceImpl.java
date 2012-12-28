package com.symbio.sbtm.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.symbio.sbtm.model.Role;
import com.symbio.sbtm.model.User;
import com.symbio.sbtm.model.dao.RoleDao;

/**
 * Implements IRole behaviors using JPA to interact with a data repository.
 * 
 * @author Ken Jiang
 * 
 */
@Service("RoleService")
public class RoleServiceImpl implements RoleDao {

	@Autowired
	private RoleDao roleDao;

	@Override
	public void save(Role role) throws Exception {
		roleDao.save(role);
	}

	@Override
	public void delete(Role role) throws Exception {
		roleDao.delete(role);
	}

	@Override
	public void update(Role role) throws Exception {
		roleDao.update(role);
	}

	@Override
	public Role getRoleByName(String name) throws Exception {
		return roleDao.getRoleByName(name);
	}

	@Override
	public List<User> getAllUserByRoleId(String userId) throws Exception {
		return roleDao.getAllUserByRoleId(userId);
	}
}
