package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.*;
import com.symbio.sbtm.model.dao.*;

@Service("IBuildService")
public class BuildService implements IBuildService {

	@Autowired
	private IBuildDao buildDao;

	@Override
	@Transactional
	public void save(Build build)  {
		buildDao.save(build);
	}

	@Override
	@Transactional
	public void delete(Build build)  {
		buildDao.delete(build);
	}

	@Override
	@Transactional
	public void update(Build build)  {
		buildDao.update(build);
	}

	@Override
	public Build getBuildByName(Project project, String name)  {
		return buildDao.getBuildByName(project, name);
	}

	@Override
	public List<Build> getAllBuilds(Project project)  {
		return buildDao.getAllBuilds(project);
	}

}
