package com.symbio.sbtm.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.*;

@Repository(value = "charterDao")
public class CharterDaoJpa implements CharterDao {

	private static final Logger logger = Logger.getLogger(CharterDaoJpa.class.getName());

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Charter charter) {
		em.persist(charter);
	}

	@Override
	public void delete(Charter charter) {
		Charter ct = em.merge(charter);
		em.remove(ct);
	}

	@Override
	public void update(Charter charter) {
		em.merge(charter);
	}

	@Override
	public Charter getCharter(long charterId) {
		try {
			return em.find(Charter.class, charterId);
		} catch (NoResultException e) {
			logger.warn("No entity found for query charter in charter: " + charterId);
		}
		return null;
	}
}
