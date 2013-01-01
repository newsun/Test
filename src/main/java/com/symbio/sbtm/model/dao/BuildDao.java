package com.symbio.sbtm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.Build;

@Repository(value = "IBuildDao")
public class BuildDao implements IBuildDao {

	private static final Logger logger = Logger.getLogger(BuildDao.class.getName());
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(Build build) throws Exception {
		entityManager.persist(build);
	}

	@Override
	public void delete(Build build) throws Exception {
		Build deletebuild = entityManager.merge(build);
		entityManager.remove(deletebuild);
	}

	@Override
	public void update(Build build) throws Exception {
		entityManager.merge(build);
	}

	@Override
	public Build getBuildByName(String name) throws Exception {
		String qlString = "from " + Build.class.getSimpleName() + " as build where build.name='" + name + "'";
		Query query = entityManager.createQuery(qlString);
		try {
			return (Build) query.getSingleResult();
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Build> getAllBuilds() throws Exception {
		String qlString = "from " + Build.class.getSimpleName();
		return entityManager.createQuery(qlString).getResultList();
	}

}
