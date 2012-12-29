package com.symbio.sbtm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.Role;
import com.symbio.sbtm.model.User;

/**
 * Implements IRole behaviors using JPA to interact with a data repository.
 * 
 * @author Ken Jiang
 * 
 */
@Repository(value="IRoleDao")
public class RoleDao implements IRoleDao {

	private static final Logger logger = Logger.getLogger(IRoleDao.class
			.getName());

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(Role role) throws Exception {
		entityManager.persist(role);
	}

	@Override
	public void delete(Role role) throws Exception {
		Role deleteRole = entityManager.merge(role);
		entityManager.remove(deleteRole);
	}

	@Override
	public void update(Role role) throws Exception {
		entityManager.merge(role);
	}

	@Override
	public List<User> getAllUserByRoleId(String userId) throws Exception {
		TypedQuery<User> query = entityManager.createQuery(
				"from " + Role.class.getName(), User.class);
		List<User> users = query.getResultList();
		return users;
	}

	@Override
	public Role getRoleByName(String name) throws Exception {
		TypedQuery<Role> query = entityManager.createQuery(
				"from " + Role.class.getName(), Role.class);
		Role role = null;
		try {
			role = query.getSingleResult();
		} catch (Exception e) {
			logger.warn("No Role was found with an role name of " + name);
		}
		return role;
	}

}
