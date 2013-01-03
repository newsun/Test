package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.*;
import com.symbio.sbtm.model.dao.*;

@Service("osService")
public class OSServiceImple implements OSService {

	@Autowired
	private OSDao osDao;

	@Override
	@Transactional
	public void save(OS os)  {
		osDao.save(os);
	}

	@Override
	@Transactional
	public void delete(OS os)  {
		osDao.delete(os);
	}

	@Override
	@Transactional
	public void update(OS os)  {
		osDao.update(os);
	}

	@Override
	public OS getOSbyName(String name)  {
		return osDao.getOSbyName(name);
	}

	@Override
	public List<OS> getAllOS()  {
		return osDao.getAllOS();
	}

}
