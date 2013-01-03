package com.symbio.sbtm.test.model.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;

import bsh.This;

import com.symbio.sbtm.model.service.*;
import com.symbio.sbtm.model.*;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class StrategySerivceTest extends AbstractTestNGSpringContextTests {

	private static final Logger logger = Logger.getLogger(StrategySerivceTest.class.getName());

	@Autowired
	private IStrategyService StrategySerivce;
	private Strategy strategy = null;
	private String strategyName = "strategyName_" + This.class.getSimpleName() + System.currentTimeMillis();

	@Test
	public void testSave() throws Exception {
		strategy = new Strategy(strategyName);
		StrategySerivce.save(strategy);
		Strategy strategy2 = StrategySerivce.getStrategyByName(strategyName);
		Assert.assertNotNull(strategy2, "Strategy is not saved successfully");
		logger.info("StrategySerivceTest.testSave passed");
	}

	@Test(dependsOnMethods = "testSave")
	public void testUpdate() throws Exception {
		Strategy Strategy = StrategySerivce.getStrategyByName(strategyName);
		Assert.assertNotNull(Strategy, "Strategy is not saved successfully");
		Strategy.setDescription("Description is udpated");
		StrategySerivce.update(Strategy);
		Strategy Strategy2 = StrategySerivce.getStrategyByName(strategyName);
		Assert.assertEquals(Strategy.getDescription(), Strategy2.getDescription(),
		        "Strategy's description is not updated");
		logger.info("StrategySerivceTest.testUpdate passed");
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testDelete() throws Exception {
		Strategy Strategy = StrategySerivce.getStrategyByName(strategyName);
		Assert.assertNotNull(Strategy, "Strategy is not saved successfully");
		StrategySerivce.delete(Strategy);
		Strategy Strategy2 = StrategySerivce.getStrategyByName(strategyName);
		Assert.assertNull(Strategy2, "Strategy is not deleted");
		logger.info("StrategySerivceTest.testDelete passed");
	}
}
