package com.symbio.sbtm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.OS;

@Repository(value = "IOSDao")
public class OSDao implements IOSDao {

	private static final Logger logger = Logger.getLogger(OSDao.class
			.getName());

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(OS os) throws Exception {
		entityManager.persist(os);
	}

	@Override
	public void delete(OS os) throws Exception {
		OS deleteOS = entityManager.merge(os);
		entityManager.remove(deleteOS);
	}

	@Override
	public void update(OS os) throws Exception {
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
	public List<OS> getAllOS() throws Exception {
		String qlString = "from " + OS.class.getSimpleName();
		return entityManager.createQuery(qlString).getResultList();
	}
}
