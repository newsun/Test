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
	private IUserService userService;

	private User user = null;
	private Project project = null;

	private String userId = "userId_CharterSerivceTest";
	private String projectName = "projectName_CharterSerivceTest";

	@BeforeClass
	public void beforeClass() throws Exception {
		user = new User(userId, "1111");
		userService.save(user);
	}

	@Test
	public void testSave() throws Exception {
		project = new Project(projectName, user);
		projectService.save(project);
		project = projectService.getProjectByName(projectName);
		Assert.assertNotNull(project, "project is not saved successfully");
		logger.info("ProjectSerivceTest.testSave passed");
	}

	@Test(dependsOnMethods = "testSave")
	public void testUpdate() throws Exception {
		project.setDescription("Description is udpated");
		projectService.update(project);
		project = projectService.getProjectByName(projectName);
		Assert.assertEquals(project.getDescription(), "Description is udpated", "Project's description is not updated");
		logger.info("ProjectSerivceTest.testUpdate passed");
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testLink() throws Exception {
		User us = project.getCreator();
		Assert.assertEquals(user, us, "project creator is not correct!");

		user = userService.getUserByUserId(userId);
		Assert.assertTrue(user.getCreatedProjects().contains(project), "user's create project list is wrong");
	}

	@Test(dependsOnMethods = "testLink", expectedExceptions = { org.hibernate.LazyInitializationException.class })
	public void testDelete() {
		try {
			projectService.delete(project);
			project = projectService.getProjectByName(projectName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Assert.assertNull(project, "Project is not deleted");
		logger.info("ProjectSerivceTest.testDelete passed");
	}

	@AfterClass
	public void afterClass() throws Exception {
		if (project != null)
			projectService.delete(project);
		if (null != user)
			userService.delete(user);
	}
}
