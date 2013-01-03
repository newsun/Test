package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.Strategy;
import com.symbio.sbtm.model.dao.*;

@Service("IStrategyService")
public class StrategyService implements IStrategyService {
	@Autowired
	private IStrategyDao strategyDao;

	@Override
	@Transactional
	public void save(Strategy strategy)  {
		strategyDao.save(strategy);
	}

	@Override
	@Transactional
	public void delete(Strategy strategy)  {
		strategyDao.delete(strategy);
	}

	@Override
	@Transactional
	public void update(Strategy strategy)  {
		strategyDao.update(strategy);
	}

	@Override
	public Strategy getStrategyByName(String name)  {
		return strategyDao.getStrategyByName(name);
	}

	@Override
	public List<Strategy> getAllstrategy()  {
		return strategyDao.getAllstrategy();
	}

}
