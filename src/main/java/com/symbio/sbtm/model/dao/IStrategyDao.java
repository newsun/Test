package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.Strategy;

public interface IStrategyDao {
	public void save(Strategy strategy) ;

	public void delete(Strategy strategy) ;

	public void update(Strategy strategy) ;

	public Strategy getStrategyByName(String name) ;

	public List<Strategy> getAllstrategy() ;
}
