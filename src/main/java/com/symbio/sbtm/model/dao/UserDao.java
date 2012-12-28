package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.Role;
import com.symbio.sbtm.model.User;

public interface UserDao {
	/*
	 * Create a user
	 * 
	 * @param user
	 * 
	 * @return whether created successfully
	 * 
	 * @throws SQLException
	 */
	public void save(User user) throws Exception;

	/*
	 * Remove a user
	 * 
	 * @param user
	 * 
	 * @return whether delete successfully
	 * 
	 * @throws Exception
	 */
	public void delete(User user) throws Exception;

	/*
	 * Change user inforamtion
	 * 
	 * @param user
	 * 
	 * @return whether created successfully
	 * 
	 * @throws Exception
	 */
	public void update(User user) throws Exception;

	/*
	 * find current user's roles
	 * 
	 * @param user
	 * 
	 * @return whether created successfully
	 * 
	 * @throws Exception
	 */

	public List<Role> getRoles(String userId) throws Exception;

	/*
	 * find a user whether exists
	 * 
	 * @param user
	 * 
	 * @return whether created successfully
	 * 
	 * @throws Exception
	 */
	public User getUserByUserId(String userId) throws Exception;
}
