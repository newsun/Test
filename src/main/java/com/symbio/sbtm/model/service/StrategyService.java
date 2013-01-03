package com.symbio.sbtm.model.service;

import java.util.List;

import com.symbio.sbtm.model.Strategy;

public interface StrategyService {
	public void save(Strategy strategy) ;

	public void delete(Strategy strategy) ;

	public void update(Strategy strategy) ;

	public Strategy getStrategyByName(String name) ;

	public List<Strategy> getAllstrategy() ;
}
