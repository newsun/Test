package com.symbio.sbtm.test.model.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;

import com.symbio.sbtm.model.Role;
import com.symbio.sbtm.model.service.IRoleService;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class RoleServiceTest extends AbstractTestNGSpringContextTests {

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
			Assert.fail(e.getMessage());
		}
	}

	@Test(dataProvider = "roleData", dependsOnMethods = "testSave")
	public void testDelete(String name, String description) {
		try {
			Role role = roleService.getRoleByName(name);
			roleService.delete(role);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Failed to delete role with role name of " + name);
			Assert.fail(e.getMessage());
		}
	}
}