package com.symbio.sbtm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.Role;

/**
 * Implements IRole behaviors using JPA to interact with a data repository.
 * 
 * @author Ken Jiang
 * 
 */
@Repository(value = "roleDao")
public class RoleDaoJpa implements RoleDao {

	private static final Logger logger = Logger.getLogger(RoleDaoJpa.class
			.getName());
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Role role)  {
		entityManager.persist(role);
	}

	@Override
	public void delete(Role role)  {
		Role deleteRole = entityManager.merge(role);
		entityManager.remove(deleteRole);
	}

	@Override
	public void update(Role role)  {
		entityManager.merge(role);
	}

	@Override
	public Role getRoleByName(String name)  {
		String sql = "from " + Role.class.getSimpleName()
				+ " as role where role.name='" + name + "'";
		Query query = entityManager.createQuery(sql);
		Role role = null;
		try {
			role = (Role) query.getSingleResult();
		} catch (Exception e) {
			logger.warn("No Role was found with an role name of " + name);
		}
		return role;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRoles()  {
		String qlString = "from Role";
		Query query = entityManager.createQuery(qlString);
		try {
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
