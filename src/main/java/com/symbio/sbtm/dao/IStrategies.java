package com.symbio.sbtm.dao;

import java.util.ArrayList;

import com.symbio.sbtm.vo.Charter;
import com.symbio.sbtm.vo.Strategies;

public interface IStrategies {
	public void doCreate(Strategies strategies) throws Exception;

	public void doDelete(Strategies strategies) throws Exception;

	public void doUpdate(Strategies strategies) throws Exception;

	public ArrayList<Strategies> getStrategies(Strategies strategies)
			throws Exception;

	public ArrayList<Strategies> getStrategies(Charter charter)
			throws Exception;

	public ArrayList<Strategies> getAllstrategies() throws Exception;
}
