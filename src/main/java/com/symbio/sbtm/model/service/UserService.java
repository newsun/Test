package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.symbio.sbtm.model.dao.*;
import com.symbio.sbtm.model.Role;
import com.symbio.sbtm.model.User;

/**
 * Implements IUser behaviors using JPA to interact with a data repository.
 * 
 * @author Ken Jiang
 * 
 */
@Service("IUserService")
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional
	public void save(User user) throws Exception {
		userDao.save(user);
	}

	@Override
	@Transactional
	public void delete(User user) throws Exception {
		userDao.delete(user);
	}

	@Override
	@Transactional
	public void update(User user) throws Exception {
		userDao.update(user);
	}

	@Override
	public List<Role> getRoles(String userId) throws Exception {
		return userDao.getRoles(userId);
	}

	@Override
	public User getUserByUserId(String userId) throws Exception {
		return userDao.getUserByUserId(userId);
	}
}
