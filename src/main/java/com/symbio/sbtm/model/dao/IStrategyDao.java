package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.Strategy;

public interface IStrategyDao {
	public void save(Strategy strategy) throws Exception;

	public void delete(Strategy strategy) throws Exception;

	public void update(Strategy strategy) throws Exception;

	public Strategy getStrategyByName(String name) throws Exception;

	public List<Strategy> getAllstrategy() throws Exception;
}
