package com.symbio.sbtm.model;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.*;
import com.symbio.sbtm.model.service.*;

@ContextConfiguration(locations = { "classpath*:applicationContextTest.xml" })
public class RoleModelTest {

	private static final Logger logger = Logger.getLogger(RoleModelTest.class
			.getName());

	@Autowired
	private IRoleService roleService;

	@Test(dataProvider = "roleData", dataProviderClass = UserModelTest.class)
	public void testSave(String name, String description) {
		Role role = new Role();
		role.setName(name);
		role.setDescription(description);
		try {
			roleService.save(role);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Failed to create role with role name of " + name);
			Assert.fail();
		}
	}
}
