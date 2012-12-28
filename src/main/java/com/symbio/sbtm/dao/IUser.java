package com.symbio.sbtm.dao;

import java.util.ArrayList;

import com.symbio.sbtm.vo.User;

public interface IUser {
	/*
	 * Create a user
	 * 
	 * @param user
	 * 
	 * @return whether created successfully
	 * 
	 * @throws SQLException
	 */
	public void doCreate(User user) throws Exception;

	/*
	 * Remove a user
	 * 
	 * @param user
	 * 
	 * @return whether delete successfully
	 * 
	 * @throws Exception
	 */
	public void doDelete(User user) throws Exception;

	/*
	 * Change user inforamtion
	 * 
	 * @param user
	 * 
	 * @return whether created successfully
	 * 
	 * @throws Exception
	 */
	public void doUpdate(User user) throws Exception;

	/*
	 * find all users
	 * 
	 * @param user
	 * 
	 * @return whether created successfully
	 * 
	 * @throws Exception
	 */

	public ArrayList<User> getAllUsers() throws Exception;

	/*
	 * find a user whether exists
	 * 
	 * @param user
	 * 
	 * @return whether created successfully
	 * 
	 * @throws Exception
	 */
	public ArrayList<User> getUser(User user) throws Exception;
}
