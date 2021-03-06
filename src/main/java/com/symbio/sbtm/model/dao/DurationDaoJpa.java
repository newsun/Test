package com.symbio.sbtm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.Duration;
import com.symbio.sbtm.model.OS;

@Repository(value = "durationDao")
public class DurationDaoJpa implements DurationDao {
	private static final Logger logger = Logger.getLogger(DurationDaoJpa.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Duration duration)  {
		entityManager.persist(duration);
	}

	@Override
	public void delete(Duration duration)  {
		Duration deleteDuration = entityManager.merge(duration);
		entityManager.remove(deleteDuration);
	}

	@Override
	public void update(Duration duration)  {
		entityManager.merge(duration);
	}

	@Override
	public Duration getDurationByName(String name)  {
		String qlString = "from " + Duration.class.getSimpleName() + " as du where du.name='" + name + "'";
		Query query = entityManager.createQuery(qlString);
		try {
			return (Duration) query.getSingleResult();
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Duration> getAllDurations()  {
		String qlString = "from " + OS.class.getSimpleName();
		return entityManager.createQuery(qlString).getResultList();
	}

}
