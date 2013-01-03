package com.symbio.sbtm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.Area;
import com.symbio.sbtm.model.Build;
import com.symbio.sbtm.model.Project;

@Repository(value = "areaDao")
public class AreaDaoJpa implements AreaDao {

	private static final Logger logger = Logger.getLogger(AreaDaoJpa.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Area area) {
		entityManager.persist(area);
	}

	@Override
	public void delete(Area area) {
		Area deletearea = entityManager.merge(area);
		entityManager.remove(deletearea);
	}

	@Override
	public void update(Area area) {
		entityManager.merge(area);
	}

	@Override
	public Area getAreaByName(Project project, String name) {
		String qlString = "from " + Area.class.getSimpleName()
		        + " as area where area.name=:name and area.project.id=:pid";

		Query query = entityManager.createQuery(qlString).setParameter("name", name)
		        .setParameter("pid", project.getId());
		try {
			return (Area) query.getSingleResult();
		} catch (NoResultException e) {
			logger.warn("No entity found for query area in (project: " + project.getId() + ", area: " + name);
		}
		return null;
	}

	@Override
	public Area getAreaByName(Build build, String name) {
		String qlString = "select a from " + Area.class.getSimpleName() + " a,Build b where b.id=:bid and a.name=:name";
		Query query = entityManager.createQuery(qlString).setParameter("name", name).setParameter("bid", build.getId());
		try {
			return (Area) query.getSingleResult();
		} catch (NoResultException e) {
			logger.warn("No entity found for query area in (build: " + build.getId() + ", area: " + name);
		}
		return null;
	}

	@Override
	public Area getAreaById(Long id) {
		String qlString = "from " + Area.class.getSimpleName() + " as area where area.id=:id";
		Query query = entityManager.createQuery(qlString).setParameter("id", id);
		try {
			return (Area) query.getSingleResult();
		} catch (NoResultException e) {
			logger.warn("No entity found for query area id: " + id);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> getAllAreaInProject(Project project) {
		String qlString = "from " + Area.class.getSimpleName() + " as area where area.project。id=:id";
		Query query = entityManager.createQuery(qlString).setParameter("id", project.getId());
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			logger.warn("No entity found for query area in project: " + project.getId());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> getAllAreaInBuild(Build build) {
		String qlString = "select a from " + Area.class.getSimpleName()
		        + " a,Build b where b.id=:bid and a.builds.build.id=:bid";
		Query query = entityManager.createQuery(qlString).setParameter("bid", build.getId());
		try {
			return query.getResultList();
		} catch (NoResultException e) {
			logger.warn("No entity found for query area in build: " + build.getId());
		}
		return null;
	}
}
