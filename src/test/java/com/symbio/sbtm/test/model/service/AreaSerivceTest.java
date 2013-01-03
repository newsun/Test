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
public class AreaSerivceTest extends AbstractTestNGSpringContextTests {

	private static final Logger logger = Logger.getLogger(AreaSerivceTest.class.getName());
	@Autowired
	private AreaService areaService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	@Autowired
	private BuildService buildService;

	private User user = null;
	private Project project = null;
	private Build build = null;
	private Area area = null;
	private String userId = "userId_" + this.getClass().getSimpleName() + System.currentTimeMillis();
	private String projectName = "projectName_" + this.getClass().getSimpleName() + System.currentTimeMillis();
	private String buildName = "buildName_" + this.getClass().getSimpleName() + System.currentTimeMillis();
	private String areaName = "areaName_" + this.getClass().getSimpleName() + System.currentTimeMillis();

	@BeforeClass
	public void beforeClass() throws Exception {
		user = new User(userId, "1111");
		userService.save(user);
		project = new Project(projectName, user);
		projectService.save(project);
		build = new Build(buildName, project);
		buildService.save(build);
	}

	@Test
	public void testSave() throws Exception {
		area = new Area(areaName, project);
		areaService.save(area);
		Assert.assertNotNull(area, "area is not saved successfully");

		project = projectService.getProjectByName(projectName);
		Assert.assertTrue(project.getAreas().contains(area), "Don't get inserted area in project");

		logger.info("AreaSerivceTest.testSave passed");
	}

	@Test(dependsOnMethods = "testSave")
	public void testUpdate() throws Exception {
		area.setDescription("Description is udpated by area");
		area.getBuilds().add(build);
		areaService.update(area);
		area = areaService.getAreaByName(project, area.getName());
		Assert.assertEquals(area.getDescription(), "Description is udpated by area",
		        "Description udpate by area failed");
		Assert.assertFalse(area.getBuilds().contains(build), "Check area's build failed");

		build.getAreas().add(area);
		buildService.update(build);
		build = buildService.getBuildByName(project, buildName);
		area = areaService.getAreaByName(build, areaName);
		Assert.assertTrue(area.getBuilds().contains(build), "Check area's build failed");

		build = buildService.getBuildByName(project, build.getName());

		Assert.assertTrue(build.getAreas().contains(area));

		logger.info("AreaSerivceTest.testUpdate passed");
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testDelete() throws Exception {
		areaService.delete(area);
		area = areaService.getAreaByName(project, areaName);
		Assert.assertNull(area, "Area is not deleted.");

		project = projectService.getProjectByName(project.getName());
		Assert.assertNotNull(project, "Project is deleted wrongly when delete its area");
		build = buildService.getBuildByName(project, build.getName());
		Assert.assertNotNull(build, "build is deleted wrongly when delete its area");
		Assert.assertFalse(build.getAreas().contains(area));
	}

	@AfterClass
	public void afterClass() throws Exception {
		// don't have to delete project first
		// if (project != null && build != null)
		// buildService.delete(build);
		if (project != null)
			projectService.delete(project);
		if (user != null)
			userService.delete(user);
	}
}
