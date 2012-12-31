package com.symbio.sbtm.test.model.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.symbio.sbtm.model.service.*;
import com.symbio.sbtm.model.*;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class OSSserviceTest extends AbstractTestNGSpringContextTests {

	private static final Logger logger = Logger.getLogger(OSSserviceTest.class
			.getName());

	@Autowired
	private IOSService osService;

	@Test
	public void testSave() {
		OS os = new OS("win8");
		os.setDescription("Windows 8");
		try {
			osService.save(os);
			OS o = osService.getOSbyName("win8");
			Assert.assertNotNull(o, "OS win8 is not saved");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Test(dependsOnMethods = "testSave")
	public void testDelete() {
		try {
			OS o = osService.getOSbyName("win8");
			Assert.assertNotNull(o, "OS win8 is not saved");

			osService.delete(o);
			OS o2 = osService.getOSbyName("win8");
			Assert.assertNull(o2, "OS win8 is not deleted");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
}
