package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.Project;
import com.symbio.sbtm.model.dao.*;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectDao;

	@Override
	@Transactional
	public void save(Project project) {
		projectDao.save(project);
	}

	@Override
	@Transactional
	public void delete(Project project) {
		projectDao.delete(project);
	}

	@Override
	@Transactional
	public void update(Project project) {
		projectDao.update(project);
	}

	@Override
	public Project getProjectByName(String name) {
		return projectDao.getProjectByName(name);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectDao.getAllProjects();
	}

	@Override
	public Project getProject(Project project) {
		return projectDao.getProject(project);
	}

	@Override
	public Project getProjectById(Long projectId) {
		return projectDao.getProjectById(projectId);
	}

}
