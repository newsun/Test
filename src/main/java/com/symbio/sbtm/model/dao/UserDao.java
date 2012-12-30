package com.symbio.sbtm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.Role;
import com.symbio.sbtm.model.User;

/**
 * Implements IUser behaviors using JPA to interact with a data repository.
 * 
 * @author Ken Jiang
 * 
 */
@Repository("IUserDao")
public class UserDao implements IUserDao {
	private static final Logger logger = Logger.getLogger(UserDao.class
			.getName());

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(User user) throws Exception {
		entityManager.persist(user);
	}

	@Override
	public void delete(User user) throws Exception {
		User deleteUser = entityManager.merge(user);
		entityManager.remove(deleteUser);
	}

	@Override
	public void update(User user) throws Exception {
		entityManager.merge(user);
	}

	@Override
	public List<Role> getRoles(String userId) throws Exception {
		TypedQuery<Role> query = entityManager.createQuery(
				"from " + User.class.getName(), Role.class);
		List<Role> roles = query.getResultList();
		return roles;
	}

	@Override
	public User getUserByUserId(String userId) throws Exception {
		User user = null;
		// TypedQuery<User> query = entityManager.createQuery(
		// "from " + User.class.getName() + " where id=" + userId,
		// User.class);
		// query.setParameter("userId", userId);
		String sql = "from " + User.class.getSimpleName() + " as user "
				+ " where user.userId='" + userId + "'";
		Query query = entityManager.createQuery(sql);
		try {
			user = (User) query.getSingleResult();
		} catch (javax.persistence.NoResultException ex) {
			logger.warn("No User was found with an userId of " + userId);
		}
		return user;
	}
}
