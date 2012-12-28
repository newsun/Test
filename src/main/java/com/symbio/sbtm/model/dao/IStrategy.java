package com.symbio.sbtm.model.dao;

import java.util.ArrayList;

import com.symbio.sbtm.model.Strategy;

public interface IStrategy {
	public void doCreate(Strategy strategy) throws Exception;

	public void doDelete(Strategy strategy) throws Exception;

	public void doUpdate(Strategy strategy) throws Exception;

	public ArrayList<Strategy> getStrategies(Strategy strategy)
			throws Exception;

	public ArrayList<Strategy> getAllstrategy() throws Exception;
}
