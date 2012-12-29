package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	private IUserService userService;

	@Override
	@Transactional
	public void save(User user) throws Exception {
		userService.save(user);
	}

	@Override
	@Transactional
	public void delete(User user) throws Exception {
		userService.delete(user);
	}

	@Override
	@Transactional
	public void update(User user) throws Exception {
		userService.update(user);
	}

	@Override
	public List<Role> getRoles(String userId) throws Exception {
		return userService.getRoles(userId);
	}

	@Override
	public User getUserByUserId(String userId) throws Exception {
		return userService.getUserByUserId(userId);
	}
}
