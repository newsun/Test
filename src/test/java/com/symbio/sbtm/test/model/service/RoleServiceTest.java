package com.symbio.sbtm.test.model.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

import com.symbio.sbtm.model.Role;
import com.symbio.sbtm.model.service.IRoleService;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class RoleServiceTest extends AbstractTestNGSpringContextTests {

	private static final Logger logger = Logger.getLogger(RoleServiceTest.class.getName());

	@Autowired
	private IRoleService roleService;

	@DataProvider(name = "roleData")
	public Object[][] rolesDataProvider() {
		return new Object[][] {
		        new Object[] { "Administrator" + this.getClass().getSimpleName(), "System Administrator" },
		        new Object[] { "Project Manager" + this.getClass().getSimpleName(), "Project Manager" },
		        new Object[] { "Creator" + this.getClass().getSimpleName(), "Component Creator" },
		        new Object[] { "Tester" + this.getClass().getSimpleName(), "Tester" } };
	}

	@Test(dataProvider = "roleData")
	public void testSave(String name, String description) {
		Role role = new Role(name);
		role.setDescription(description);
		roleService.save(role);
		logger.info("RoleServiceTest.testSave passed");
	}

	@Test(dataProvider = "roleData", dependsOnMethods = "testSave")
	public void testDelete(String name, String description) {
		Role role = roleService.getRoleByName(name);
		roleService.delete(role);
		logger.info("RoleServiceTest.testDelete passed");
	}
}
