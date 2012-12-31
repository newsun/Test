package com.symbio.sbtm.test.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;

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

	Role role = new Role("Tester");

	@BeforeClass
	public void beforeClass() throws Exception {
		roleService.update(role);
	}

	@DataProvider(name = "userData")
	public static Object[][] usersDataProvider() {
		return new Object[][] {
		// new Object[] { "admin", "System Administrator", "Administrator" },
		// new Object[] { "ppmm", "Project Manager", "Project Manager" },
		// new Object[] { "creator", "Component Creator", "Creator" },
		new Object[] { "tester", "Tester", "Tester" } };
	}

	@Test(dataProvider = "userData")
	public void testSave(String name, String description, String roleName)
			throws Exception {
		User user = new User(name, "1111");
		user.setDescription(description);
		User existUser = userService.getUserByUserId(name);
		if (existUser != null)
			return;
		Role role = roleService.getRoleByName(roleName);

		user.getRoles().add(role);

		userService.save(user);

		Assert.assertTrue(userService.getUserByUserId(name).getRoles()
				.contains(role),
				"Failed in checking the role of newly added user " + name);
	}

	@Test(dataProvider = "userData", dependsOnMethods = "testSave")
	public void testDelete(String userId, String description, String roleName)
			throws Exception {
		User user = userService.getUserByUserId(userId);
		userService.delete(user);

		user = userService.getUserByUserId(user.getUserId());

		Assert.assertNull(user, "User " + userId + " is not deleted");

		Role role = roleService.getRoleByName(roleName);

		Assert.assertNotNull(role, "Role " + roleName
				+ " is deleted wrongly where delete user " + userId);

		boolean b = role.getUsers().contains(user);

		Assert.assertFalse(b, "user " + userId
				+ "is not deleted from role group " + roleName);
	}

	@AfterClass
	public void afterClass() throws Exception {
		Role ro = roleService.getRoleByName(role.getName());
		roleService.delete(ro);
	}
}