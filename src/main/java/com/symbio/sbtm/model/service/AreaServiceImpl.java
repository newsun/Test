package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.*;
import com.symbio.sbtm.model.dao.*;

@Service("areaService")
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;

	@Override
	@Transactional
	public void save(Area area)  {
		areaDao.save(area);
	}

	@Override
	@Transactional
	public void delete(Area area)  {
		areaDao.delete(area);
	}

	@Override
	@Transactional
	public void update(Area area)  {
		areaDao.update(area);
	}

	@Override
	public Area getAreaByName(Project project, String name)  {
		return areaDao.getAreaByName(project, name);
	}

	@Override
	public Area getAreaByName(Build build, String name)  {
		return areaDao.getAreaByName(build, name);
	}

	@Override
	public List<Area> getAllAreaInBuild(Build build)  {
		return areaDao.getAllAreaInBuild(build);
	}

	@Override
	public List<Area> getAllAreaInProject(Project project)  {
		return areaDao.getAllAreaInProject(project);
	}

	@Override
	public Area getAreaById(Long id)  {
		return areaDao.getAreaById(id);
	}

}
