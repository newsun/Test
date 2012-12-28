package com.symbio.sbtm.dao.impl;

import java.util.ArrayList;

import com.symbio.sbtm.dao.IStrategy;
import com.symbio.sbtm.utils.util;
import com.symbio.sbtm.vo.Strategy;

public class StrategyImpl implements IStrategy {

	public void doCreate(Strategy strategy) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doDelete(Strategy strategy) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doUpdate(Strategy strategy) throws Exception {
		// TODO Auto-generated method stub

	}

	public ArrayList<Strategy> getStrategies(Strategy strategy)
			throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Strategy>) util.getAllObjects(Strategy.class,
				Strategy.class, strategy);
	}

	public ArrayList<Strategy> getAllstrategy() throws Exception {
		return (ArrayList<Strategy>) util.getAllObjects(Strategy.class, null,
				null);
	}

}
