package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.Project;
import com.symbio.sbtm.model.dao.*;

@Service("IProjectService")
public class ProjectService implements IProjectService {
	@Autowired
	private IProjectDao projectDao;

	@Override
	@Transactional
	public void save(Project project) throws Exception {
		projectDao.save(project);
	}

	@Override
	@Transactional
	public void delete(Project project) throws Exception {
		projectDao.delete(project);
	}

	@Override
	@Transactional
	public void update(Project project) throws Exception {
		projectDao.update(project);
	}

	@Override
	public Project getProjectByName(String name) throws Exception {
		return projectDao.getProjectByName(name);
	}

	@Override
	public List<Project> getAllProjects() throws Exception {
		return projectDao.getAllProjects();
	}

}
