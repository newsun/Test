package com.symbio.sbtm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.*;

@Repository(value = "bugDao")
public class BugDaoJpa implements BugDao {

	private static final Logger logger = Logger.getLogger(BugDaoJpa.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Bug bug) {
		entityManager.persist(bug);
	}

	@Override
	public void delete(Bug bug) {
		Bug deletebug = entityManager.merge(bug);
		entityManager.remove(deletebug);
	}

	@Override
	public void update(Bug bug) {
		entityManager.merge(bug);
	}

	@Override
	public Bug getBug(Long bugId) {
		try {
			return entityManager.find(Bug.class, bugId);
		} catch (NoResultException e) {
			logger.warn("No entity found for query charter in bugId: " + bugId);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bug> getAllBugs(Long charterId) {
		String qlString = "from Bug b where b.charter.id=:cid";
		try {
			return entityManager.createQuery(qlString).setParameter("cid", charterId).getResultList();
		} catch (NoResultException e) {
			logger.warn("No entity found for query charter in charterId: " + charterId);
		}
		return null;
	}
}
