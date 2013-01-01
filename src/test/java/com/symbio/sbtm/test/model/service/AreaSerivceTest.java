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
	private IAreaService areaService;
	@Autowired
	private IProjectService projectService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IBuildService buildService;

	private User user = null;
	private Project project = null;
	private Build build = null;

	@BeforeClass
	public void beforeClass() throws Exception {
		user = new User("tester", "1111");
		userService.update(user);
		user = userService.getUserByUserId(user.getUserId());
		project = new Project("testProject", user);
		projectService.update(project);
		project = projectService.getProjectByName(project.getName());
		build = new Build("Area1", project);
		buildService.save(build);
		build = buildService.getBuildByName(build.getName());
	}

	@Test
	public void testSave() throws Exception {
		Area area = new Area("Area1", project);

		areaService.save(area);
		Area area2 = areaService.getAreaByName("Area1");
		Assert.assertNotNull(area2, "area is not saved successfully");
		logger.info("AreaSerivceTest.testSave passed");
	}

	@Test(dependsOnMethods = "testSave")
	public void testUpdate() throws Exception {
		Area area = areaService.getAreaByName("Area1");
		Assert.assertNotNull(area, "area is not saved successfully");

		area.setDescription("Description is udpated");

		build.getAreas().add(area);
		buildService.update(build);

		areaService.update(area);
		Area area2 = areaService.getAreaByName("Area1");
		Assert.assertEquals(area.getDescription(), area2.getDescription(), "Area's description is not updated");
		Assert.assertTrue(area2.getBuilds().contains(build), "Area's build list is not updated");

		logger.info("AreaSerivceTest.testUpdate passed");
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testDelete() throws Exception {
		Area area = areaService.getAreaByName("Area1");
		Assert.assertNotNull(area, "area is not saved successfully");
		areaService.delete(area);
		Area area2 = areaService.getAreaByName("Area1");
		Assert.assertNull(area2, "Area is not deleted.");

		Project project = projectService.getProjectByName(area.getProject().getName());
		Assert.assertNotNull(project, "Project is deleted wrongly when delete its area");
		Build build = buildService.getBuildByName(area.getBuilds().get(0).getName());
		Assert.assertNotNull(build, "build is deleted wrongly when delete its area");
		Assert.assertFalse(build.getAreas().contains(area));
	}

	@Test(dependsOnMethods = "testDelete")
	public void testLink() throws Exception {
		Area area = new Area("Area1", project);
		areaService.save(area);
		Area area2 = areaService.getAreaByName("Area1");
		Assert.assertNotNull(area2, "area is not saved successfully");
		Assert.assertEquals(project, area2.getProject(), "Area's project is not save successfully");

		projectService.delete(project);
		project = projectService.getProjectByName(project.getName());
		Assert.assertNull(project, "Failed to delete project");
		Area area3 = areaService.getAreaByName("Area1");
		Assert.assertNull(area3, "area is not delete when delete its parent project");

		logger.info("AreaSerivceTest.testDelete passed");
	}

	@AfterClass
	public void afterClass() throws Exception {
		// have to delete project first
		if (project != null && build != null)
			buildService.delete(build);
		if (project != null)
			projectService.delete(project);
		if (user != null)
			userService.delete(user);
	}
}
