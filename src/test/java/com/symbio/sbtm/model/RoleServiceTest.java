package com.symbio.sbtm.model;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.*;
import com.symbio.sbtm.model.service.*;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class RoleServiceTest {

	private static final Logger logger = Logger.getLogger(RoleServiceTest.class
			.getName());

	@Autowired
	private IRoleService roleService;

	@DataProvider(name = "roleData")
	public static Object[][] rolesDataProvider() {
		return new Object[][] {
				new Object[] { "Administrator", "System Administrator" },
				new Object[] { "Project Manager", "Project Manager" },
				new Object[] { "Creator", "Component Creator" },
				new Object[] { "Tester", "Tester" } };
	}

	@Test(dataProvider = "roleData")
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
