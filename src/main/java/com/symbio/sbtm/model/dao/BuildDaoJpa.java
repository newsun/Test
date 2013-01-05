package com.symbio.sbtm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.*;

@Repository(value = "buildDao")
public class BuildDaoJpa implements BuildDao {

	private static final Logger logger = Logger.getLogger(BuildDaoJpa.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Build build) {
		entityManager.persist(build);
	}

	@Override
	public void delete(Build build) {
		Build deletebuild = entityManager.merge(build);
		entityManager.remove(deletebuild);
	}

	@Override
	public void update(Build build) {
		entityManager.merge(build);
	}

	@Override
	public Build getBuildByName(Project project, String name) {
		String qlString = "from " + Build.class.getSimpleName()
		        + " as b where b.name=:name and b.project.id=:pid";
		Query query = entityManager.createQuery(qlString).setParameter("name", name)
		        .setParameter("pid", project.getId());
		try {
			return (Build) query.getSingleResult();
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Build> getAllBuilds(Project project) {
		String qlString = "from " + Build.class.getSimpleName() + " as b where b.project.id=:pid";
		return entityManager.createQuery(qlString).setParameter("pid", project.getId()).getResultList();
	}

}
