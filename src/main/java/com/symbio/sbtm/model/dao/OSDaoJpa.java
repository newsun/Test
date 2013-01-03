package com.symbio.sbtm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.OS;

@Repository(value = "osDao")
public class OSDaoJpa implements OSDao {

	private static final Logger logger = Logger.getLogger(OSDaoJpa.class
			.getName());
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(OS os)  {
		entityManager.persist(os);
	}

	@Override
	public void delete(OS os)  {
		OS deleteOS = entityManager.merge(os);
		entityManager.remove(deleteOS);
	}

	@Override
	public void update(OS os)  {
		entityManager.merge(os);
	}

	@Override
	public OS getOSbyName(String name) {
		String qlString = "from " + OS.class.getSimpleName()
				+ " as os where os.name='" + name + "'";
		Query query = entityManager.createQuery(qlString);
		try {
			return (OS) query.getSingleResult();
		} catch (Exception e) {
			// e.printStackTrace();
			logger.warn(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OS> getAllOS()  {
		String qlString = "from " + OS.class.getSimpleName();
		return entityManager.createQuery(qlString).getResultList();
	}
}
