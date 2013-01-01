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
public class BuildSerivceTest extends AbstractTestNGSpringContextTests {

	private static final Logger logger = Logger.getLogger(BuildSerivceTest.class.getName());

	@Autowired
	private IBuildService buildService;
	@Autowired
	private IProjectService projectService;
	@Autowired
	private IUserService userService;

	User user = null;
	Project project = null;

	@BeforeClass
	public void beforeClass() throws Exception {
		user = new User("tester", "1111");
		userService.update(user);
		project = new Project("testProject", user);
		projectService.update(project);
	}

	@Test
	public void testSave() throws Exception {
		Build build = new Build("Normal", project);
		buildService.save(build);
		Build build2 = buildService.getBuildByName("Normal");
		Assert.assertNotNull(build2, "build is not saved successfully");
		logger.info("BuildSerivceTest.testSave passed");
	}

	@Test(dependsOnMethods = "testSave")
	public void testUpdate() throws Exception {
		Build build = buildService.getBuildByName("Normal");
		Assert.assertNotNull(build, "build is not saved successfully");
		
		build.setDescription("Description is udpated");
		buildService.update(build);
		Build build2 = buildService.getBuildByName("Normal");
		Assert.assertEquals(build.getDescription(), build2.getDescription(), "Build's description is not updated");
		logger.info("BuildSerivceTest.testUpdate passed");
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testDelete() throws Exception {
		Build build = buildService.getBuildByName("Normal");
		Assert.assertNotNull(build, "build is not saved successfully");
		buildService.delete(build);
		Build build2 = buildService.getBuildByName("Normal");
		Assert.assertNull(build2, "Build is not deleted");
		logger.info("BuildSerivceTest.testDelete passed");
	}

	@AfterClass
	public void afterClass() throws Exception {
		// have to delete project first
		if (project != null)
			projectService.delete(project);
		if (user != null)
			userService.delete(user);
	}
}
