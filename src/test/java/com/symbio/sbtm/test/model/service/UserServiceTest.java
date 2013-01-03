package com.symbio.sbtm.test.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;

import bsh.This;

import com.symbio.sbtm.model.Role;
import com.symbio.sbtm.model.User;
import com.symbio.sbtm.model.service.IRoleService;
import com.symbio.sbtm.model.service.IUserService;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class UserServiceTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;

	private Role role = null;
	private User user = null;

	private String userId = "userId_" + This.class.getSimpleName() + System.currentTimeMillis();
	private String roleName = "charterName_" + This.class.getSimpleName() + System.currentTimeMillis();

	@BeforeClass
	public void beforeClass() throws Exception {
		logger.info("UserServiceTest begin");
		role = new Role(roleName);
		roleService.save(role);
	}

	@Test
	public void testSave() throws Exception {
		user = new User(userId, "1111");
		user.getRoles().add(role);
		userService.save(user);
		Assert.assertTrue(user.getRoles().contains(role), "Failed in checking the role of newly added user " + userId);

		role = roleService.getRoleByName(roleName);
		Assert.assertTrue(role.getUsers().contains(user), "Failed in checking the role of newly added user " + userId);

	}

	@Test(dependsOnMethods = "testSave")
	public void testDelete() throws Exception {
		userService.delete(user);
		user = userService.getUserByUserId(user.getUserId());
		Assert.assertNull(user, "User " + userId + " is not deleted");

		role = roleService.getRoleByName(roleName);
		Assert.assertNotNull(role, "Role " + roleName + " is deleted wrongly where delete user " + userId);
		boolean b = role.getUsers().contains(user);
		Assert.assertFalse(b, "user " + userId + "is not deleted from role group " + roleName);
	}

	@AfterClass
	public void afterClass() throws Exception {
		if (user != null)
			userService.delete(user);
		if (role != null)
			roleService.delete(role);
	}
}
