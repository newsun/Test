package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.*;
import com.symbio.sbtm.model.dao.*;

@Service("IOSService")
public class OSService implements IOSService {

	@Autowired
	private IOSDao osDao;

	@Override
	@Transactional
	public void save(OS os) throws Exception {
		osDao.save(os);
	}

	@Override
	@Transactional
	public void delete(OS os) throws Exception {
		osDao.delete(os);
	}

	@Override
	@Transactional
	public void update(OS os) throws Exception {
		osDao.update(os);
	}

	@Override
	public OS getOSbyName(String name) throws Exception {
		return osDao.getOSbyName(name);
	}

	@Override
	public List<OS> getAllOS() throws Exception {
		return osDao.getAllOS();
	}

}
