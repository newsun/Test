package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.*;
import com.symbio.sbtm.model.dao.*;

@Service("IAreaService")
public class AreaService implements IAreaService {

	@Autowired
	private IAreaDao areaDao;

	@Override
	@Transactional
	public void save(Area area) throws Exception {
		areaDao.save(area);
	}

	@Override
	@Transactional
	public void delete(Area area) throws Exception {
		areaDao.delete(area);
	}

	@Override
	@Transactional
	public void update(Area area) throws Exception {
		areaDao.update(area);
	}

	@Override
	public Area getAreaByName(Project project, String name) throws Exception {
		return areaDao.getAreaByName(project, name);
	}

	@Override
	public Area getAreaByName(Build build, String name) throws Exception {
		return areaDao.getAreaByName(build, name);
	}

	@Override
	public List<Area> getAllAreaInBuild(Build build) throws Exception {
		return areaDao.getAllAreaInBuild(build);
	}

	@Override
	public List<Area> getAllAreaInProject(Project project) throws Exception {
		return areaDao.getAllAreaInProject(project);
	}

	@Override
	public Area getAreaById(Long id) throws Exception {
		return areaDao.getAreaById(id);
	}

}
