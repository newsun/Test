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
public class ProjectSerivceTest extends AbstractTestNGSpringContextTests {

	private static final Logger logger = Logger.getLogger(ProjectSerivceTest.class.getName());

	@Autowired
	private IProjectService projectService;
	@Autowired
	private IRoleService roleService;

	@Autowired
	private IUserService userService;

	private Role role = null;
	private User user = null;

	@BeforeClass
	public void beforeClass() throws Exception {
		role = new Role("Tester");
		roleService.save(role);
		user = new User("tester", "1111");
		user.getRoles().add(role);
		userService.save(user);
	}

	@Test
	public void testSave() throws Exception {
		Project project = new Project("Normal", user);
		projectService.save(project);
		Project project2 = projectService.getProjectByName("Normal");
		Assert.assertNotNull(project2, "project is not saved successfully");
		logger.info("ProjectSerivceTest.testSave passed");
	}

	@Test(dependsOnMethods = "testSave")
	public void testUpdate() throws Exception {
		Project project = projectService.getProjectByName("Normal");
		Assert.assertNotNull(project, "project is not saved successfully");
		project.setDescription("Description is udpated");
		projectService.update(project);
		Project project2 = projectService.getProjectByName("Normal");
		Assert.assertEquals(project.getDescription(), project2.getDescription(), "Project's description is not updated");
		logger.info("ProjectSerivceTest.testUpdate passed");
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testDelete() throws Exception {
		Project project = projectService.getProjectByName("Normal");
		Assert.assertNotNull(project, "project is not saved successfully");
		projectService.delete(project);
		Project project2 = projectService.getProjectByName("Normal");
		Assert.assertNull(project2, "Project is not deleted");
		logger.info("ProjectSerivceTest.testDelete passed");
	}

	@AfterClass
	public void afterClass() throws Exception {
		userService.delete(user);
		roleService.delete(role);
	}
}
