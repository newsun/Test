package com.symbio.sbtm.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.dao.UserDao;
import com.symbio.sbtm.model.User;

/**
 * Implements IUser behaviors using JPA to interact with a data repository.
 * 
 * @author Ken Jiang
 * 
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public void save(User user)  {
		userDao.save(user);
	}

	@Override
	@Transactional
	public void delete(User user)  {
		userDao.delete(user);
	}

	@Override
	@Transactional
	public void update(User user)  {
		userDao.update(user);
	}

	@Override
	public User getUserByUserId(String userId)  {
		return userDao.getUserByUserId(userId);
	}
}
