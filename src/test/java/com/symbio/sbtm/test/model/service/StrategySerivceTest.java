package com.symbio.sbtm.test.model.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;

import com.symbio.sbtm.model.service.*;
import com.symbio.sbtm.model.*;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class StrategySerivceTest extends AbstractTestNGSpringContextTests {

	private static final Logger logger = Logger.getLogger(StrategySerivceTest.class.getName());

	@Autowired
	private IStrategyService StrategySerivce;

	@Test
	public void testSave() throws Exception {
		Strategy strategy = new Strategy("Normal");
		StrategySerivce.save(strategy);
		Strategy strategy2 = StrategySerivce.getStrategyByName("Normal");
		Assert.assertNotNull(strategy2, "Strategy is not saved successfully");
		logger.info("StrategySerivceTest.testSave passed");
	}

	@Test(dependsOnMethods = "testSave")
	public void testUpdate() throws Exception {
		Strategy Strategy = StrategySerivce.getStrategyByName("Normal");
		Assert.assertNotNull(Strategy, "Strategy is not saved successfully");
		Strategy.setDescription("Description is udpated");
		StrategySerivce.update(Strategy);
		Strategy Strategy2 = StrategySerivce.getStrategyByName("Normal");
		Assert.assertEquals(Strategy.getDescription(), Strategy2.getDescription(),
		        "Strategy's description is not updated");
		logger.info("StrategySerivceTest.testUpdate passed");
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testDelete() throws Exception {
		Strategy Strategy = StrategySerivce.getStrategyByName("Normal");
		Assert.assertNotNull(Strategy, "Strategy is not saved successfully");
		StrategySerivce.delete(Strategy);
		Strategy Strategy2 = StrategySerivce.getStrategyByName("Normal");
		Assert.assertNull(Strategy2, "Strategy is not deleted");
		logger.info("StrategySerivceTest.testDelete passed");
	}
}
