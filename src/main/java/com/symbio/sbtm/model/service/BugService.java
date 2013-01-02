package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.*;
import com.symbio.sbtm.model.dao.*;

@Service("IBugService")
public class BugService implements IBugService {

	@Autowired
	private IBugDao bugDao;

	@Override
	@Transactional
	public void save(Bug bug) {
		bugDao.save(bug);
	}

	@Override
	@Transactional
	public void delete(Bug bug) {
		bugDao.delete(bug);
	}

	@Override
	@Transactional
	public void update(Bug bug) {
		bugDao.update(bug);
	}

	@Override
	public Bug getBug(Long bugId) {
		return bugDao.getBug(bugId);
	}

	@Override
	public List<Bug> getAllBugs(Long charterId) {
		return bugDao.getAllBugs(charterId);
	}
}
