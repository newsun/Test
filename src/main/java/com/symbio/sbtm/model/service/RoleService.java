package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.dao.IRoleDao;
import com.symbio.sbtm.model.Role;

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
	public void save(Role role)  {
		roleDao.save(role);
	}

	@Override
	@Transactional
	public void delete(Role role)  {
		roleDao.delete(role);
	}

	@Override
	@Transactional
	public void update(Role role)  {
		roleDao.update(role);
	}

	@Override
	public Role getRoleByName(String name)  {
		return roleDao.getRoleByName(name);
	}

	@Override
	public List<Role> getAllRoles()  {
		return roleDao.getAllRoles();
	}
}
