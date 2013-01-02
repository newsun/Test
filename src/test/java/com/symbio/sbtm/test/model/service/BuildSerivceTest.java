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

	private User user = null;
	private Project project = null;
	private Build build = null;
	private String userId = "userId_BuildSerivceTest";
	private String projectName = "projectName_BuildSerivceTest";
	private String buildName = "buildName_BuildSerivceTest";

	@BeforeClass
	public void beforeClass() throws Exception {
		user = new User(userId, "1111");
		userService.save(user);
		project = new Project(projectName, user);
		projectService.save(project);
	}

	@Test
	public void testSave() throws Exception {
		build = new Build(buildName, project);
		buildService.save(build);
		// used below to test whether the unique work. result: doesn't work
		// Build build1 = new Build(buildName, project);
		// buildService.save(build1);
		build = buildService.getBuildByName(project, buildName);
		Assert.assertNotNull(build, "build is not saved successfully");
		logger.info("BuildSerivceTest.testSave passed");
	}

	@Test(dependsOnMethods = "testSave")
	public void testUpdate() throws Exception {
		build.setDescription("Description is udpated");
		buildService.update(build);
		Build build2 = buildService.getBuildByName(project, buildName);
		Assert.assertEquals(build.getDescription(), build2.getDescription(), "Build's description is not updated");
		logger.info("BuildSerivceTest.testUpdate passed");
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testDelete() throws Exception {
		Build build = buildService.getBuildByName(project, buildName);
		Assert.assertNotNull(build, "build is not saved successfully");
		buildService.delete(build);
		Build build2 = buildService.getBuildByName(project, buildName);
		Assert.assertNull(build2, "Build is not deleted.");

		Project project = projectService.getProjectByName(build.getProject().getName());
		Assert.assertNotNull(project, "Project is deleted wrongly when delete its build");
	}

	@Test(dependsOnMethods = "testDelete")
	public void testLink() throws Exception {
		Build build = new Build(buildName, project);
		buildService.save(build);
		Build build2 = buildService.getBuildByName(project, buildName);
		Assert.assertNotNull(build2, "build is not saved successfully");
		Assert.assertEquals(project, build2.getProject(), "Build's project is not save successfully");

		projectService.delete(project);
		project = projectService.getProjectByName(project.getName());
		Assert.assertNull(project, "Failed to delete project");
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
