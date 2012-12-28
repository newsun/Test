package com.symbio.sbtm.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.dao.RoleDao;
import com.symbio.sbtm.model.Role;
import com.symbio.sbtm.model.User;

/**
 * Implements IRole behaviors using JPA to interact with a data repository.
 * 
 * @author Ken Jiang
 * 
 */
@Service("RoleService")
public class RoleServiceImpl implements RoleDao {

	private static final Logger logger = Logger.getLogger(RoleServiceImpl.class
			.getName());

	@Autowired
	private RoleDao roleDao;

	@Override
	@Transactional
	public void save(Role role) throws Exception {
		roleDao.save(role);
	}

	@Override
	public void delete(Role role) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Role role) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Role getRoleByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUserByRoleId(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
