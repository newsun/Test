package com.symbio.sbtm.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.Area;

@Repository(value = "IAreaDao")
public class AreaDao implements IAreaDao {

	private static final Logger logger = Logger.getLogger(AreaDao.class.getName());
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(Area area) throws Exception {
		entityManager.persist(area);
	}

	@Override
	public void delete(Area area) throws Exception {
		Area deletearea = entityManager.merge(area);
		entityManager.remove(deletearea);
	}

	@Override
	public void update(Area area) throws Exception {
		entityManager.merge(area);
	}

	@Override
	public Area getAreaByName(String name) throws Exception {
		String qlString = "from " + Area.class.getSimpleName() + " as area where area.name='" + name + "'";
		Query query = entityManager.createQuery(qlString);
		try {
			return (Area) query.getSingleResult();
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		return null;
	}
}
