package com.symbio.sbtm.dao.impl;

import java.util.ArrayList;

import com.symbio.sbtm.dao.IStrategies;
import com.symbio.sbtm.utils.util;
import com.symbio.sbtm.vo.Charter;
import com.symbio.sbtm.vo.Strategies;

public class StrategiesImpl implements IStrategies {

	public void doCreate(Strategies strategies) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doDelete(Strategies strategies) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doUpdate(Strategies strategies) throws Exception {
		// TODO Auto-generated method stub

	}

	public ArrayList<Strategies> getStrategies(Strategies strategies)
			throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Strategies>) util.getAllObjects(Strategies.class,
				Strategies.class, strategies);
	}

	public ArrayList<Strategies> getStrategies(Charter charter)
			throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Strategies>) util.getAllObjects(Strategies.class,
				Charter.class, charter);
	}

	public ArrayList<Strategies> getAllstrategies() throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Strategies>) util.getAllObjects(Strategies.class,
				null, null);
	}

}
