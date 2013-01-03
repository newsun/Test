package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.Role;

public interface RoleDao {
	public void save(Role role) ;

	public void delete(Role role) ;

	public void update(Role role) ;

	public Role getRoleByName(String name) ;

	public List<Role> getAllRoles() ;
}
