package com.symbio.sbtm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.Strategy;

@Repository(value = "IStrategyDao")
public class StrategyDao implements IStrategyDao {
	private static final Logger logger = Logger.getLogger(StrategyDao.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Strategy strategy)  {
		entityManager.persist(strategy);
	}

	@Override
	public void delete(Strategy strategy)  {
		Strategy deletestrategy = entityManager.merge(strategy);
		entityManager.remove(deletestrategy);
	}

	@Override
	public void update(Strategy strategy)  {
		entityManager.merge(strategy);
	}

	@Override
	public Strategy getStrategyByName(String name)  {
		String qlString = "from " + Strategy.class.getSimpleName() + " as stra where stra.name='" + name + "'";
		Query query = entityManager.createQuery(qlString);
		try {
			return (Strategy) query.getSingleResult();
		} catch (Exception e) {
			// e.printStackTrace();
			logger.warn(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Strategy> getAllstrategy()  {
		String qlString = "from " + Strategy.class.getSimpleName();
		return entityManager.createQuery(qlString).getResultList();
	}

}
