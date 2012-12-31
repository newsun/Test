package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.dao.IRoleDao;
import com.symbio.sbtm.model.Role;
import com.symbio.sbtm.model.User;

/**
 * Implements IRole behaviors using JPA to interact with a data repository.
 * 
 * @author Ken Jiang
 * 
 */
@Service("IRoleService")
public class RoleService implements IRoleService {

	@Autowired
	private IRoleDao roleDao;

	@Override
	@Transactional
	public void save(Role role) throws Exception {
		roleDao.save(role);
	}

	@Override
	@Transactional
	public void delete(Role role) throws Exception {
		roleDao.delete(role);
	}

	@Override
	@Transactional
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

	@Override
	public List<Role> getAllRoles() throws Exception {
		return roleDao.getAllRoles();
	}
}
