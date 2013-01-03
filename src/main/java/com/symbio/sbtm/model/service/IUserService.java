package com.symbio.sbtm.model.service;

import com.symbio.sbtm.model.User;

public interface IUserService {
	/*
	 * Create a user
	 * 
	 * @param user
	 * 
	 * @return whether created successfully
	 * 
	 * @throws SQLException
	 */
	public void save(User user) ;

	/*
	 * Remove a user
	 * 
	 * @param user
	 * 
	 * @return whether delete successfully
	 * 
	 * @
	 */
	public void delete(User user) ;

	/*
	 * Change user inforamtion
	 * 
	 * @param user
	 * 
	 * @return whether created successfully
	 * 
	 * @
	 */
	public void update(User user) ;

	/*
	 * find a user whether exists
	 * 
	 * @param user
	 * 
	 * @return whether created successfully
	 * 
	 * @
	 */
	public User getUserByUserId(String userId) ;
}
