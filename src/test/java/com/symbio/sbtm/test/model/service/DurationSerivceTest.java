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
public class DurationSerivceTest extends AbstractTestNGSpringContextTests {

	private static final Logger logger = Logger.getLogger(DurationSerivceTest.class.getName());

	@Autowired
	private IDurationService durationService;

	@Test
	public void testSave() throws Exception {
		Duration duration = new Duration("Normal", "100m");
		durationService.save(duration);
		Duration duration2 = durationService.getDurationByName("Normal");
		Assert.assertNotNull(duration2, "duration is not saved successfully");
		logger.info("DurationSerivceTest.testSave passed");
	}

	@Test(dependsOnMethods = "testSave")
	public void testUpdate() throws Exception {
		Duration duration = durationService.getDurationByName("Normal");
		Assert.assertNotNull(duration, "duration is not saved successfully");
		duration.setDescription("Description is udpated");
		durationService.update(duration);
		Duration duration2 = durationService.getDurationByName("Normal");
		Assert.assertEquals(duration.getDescription(), duration2.getDescription(),
		        "Duration's description is not updated");
		logger.info("DurationSerivceTest.testUpdate passed");
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testDelete() throws Exception {
		Duration duration = durationService.getDurationByName("Normal");
		Assert.assertNotNull(duration, "duration is not saved successfully");
		durationService.delete(duration);
		Duration duration2 = durationService.getDurationByName("Normal");
		Assert.assertNull(duration2, "Duration is not deleted");
		logger.info("DurationSerivceTest.testDelete passed");
	}
}
