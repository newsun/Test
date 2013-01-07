package com.symbio.sbtm.test.model.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;

import com.symbio.sbtm.model.service.*;
import com.symbio.sbtm.model.*;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class CharterSerivceTest extends AbstractTestNGSpringContextTests {

	private static final Logger logger = Logger.getLogger(CharterSerivceTest.class.getName());

	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	@Autowired
	private BuildService buildService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private CharterService charterService;

	private User user = null;
	private Project project = null;
	private Build build = null;
	private Area area = null;
	private Charter charter = null;

	private String userId = "userId_" + this.getClass().getSimpleName() + System.currentTimeMillis();
	private String projectName = "projectName_" + this.getClass().getSimpleName() + System.currentTimeMillis();
	private String buildName = "buildName_" + this.getClass().getSimpleName() + System.currentTimeMillis();
	private String areaName = "areaName_" + this.getClass().getSimpleName() + System.currentTimeMillis();
	private String charterName = "charterName_" + this.getClass().getSimpleName() + System.currentTimeMillis();

	@BeforeClass
	public void beforeClass() throws Exception {
		user = new User(userId, "1111");
		userService.save(user);
		project = new Project(projectName, user);
		projectService.save(project);
		build = new Build(buildName, project);
		buildService.save(build);
		area = new Area(areaName, project);
		areaService.save(area);
		build.getAreas().add(area);
		buildService.update(build);
		build = buildService.getBuildByName(project, buildName);
	}

	@Test
	public void testSave() throws Exception {
		List<Area> areas = new ArrayList<Area>();
		areas.add(area);
		charter = new Charter(charterName, areas, user);
		charterService.save(charter);
		Assert.assertNotNull(charter, "charter is not saved successfully");

		area = areaService.getAreaById(area.getId());
		Assert.assertTrue(area.getCharters().contains(charter), "Failed to verify the newly added charter in area");
		logger.info("CharterSerivceTest.testSave passed");
	}

	@Test(dependsOnMethods = "testSave")
	public void testUpdate() throws Exception {
		charter.setDescription("Description is udpated");
		charterService.update(charter);
		// charter = charterService.getCharter(charter);

		buildService.update(build);

		charter = charterService.getCharter(charter.getId());
		Assert.assertEquals(charter.getDescription(), "Description is udpated", "Charter's description is not updated");

		build = buildService.getBuildByName(project, buildName);
		boolean b = false;
		for (java.util.Iterator<Area> it = build.getAreas().iterator(); it.hasNext();) {
			if (it.next().getCharters().contains(charter)) {
				b = true;
				break;
			}
		}
		Assert.assertTrue(b, "Don't find the charter in build");
		logger.info("CharterSerivceTest.testUpdate passed");
	}

	@Test(dependsOnMethods = "testUpdate")
	public void testDelete() throws Exception {
		charter = charterService.getCharter(charter.getId());
		Assert.assertNotNull(charter, "charter is not saved successfully");
		charterService.delete(charter);
		Charter charter2 = charterService.getCharter(charter.getId());
		Assert.assertNull(charter2, "Charter is not deleted.");

		project = projectService.getProjectByName(project.getName());
		Assert.assertNotNull(project, "Project is deleted wrongly when delete its charter");
		build = buildService.getBuildByName(project, buildName);
		Assert.assertNotNull(build, "build is deleted wrongly when delete its charter");
	}

	@AfterClass
	public void afterClass() throws Exception {
		// have to delete project first
		// if (project != null && build != null)
		// buildService.delete(build);
		if (project != null)
			projectService.delete(project);
		if (user != null)
			userService.delete(user);
	}
}
