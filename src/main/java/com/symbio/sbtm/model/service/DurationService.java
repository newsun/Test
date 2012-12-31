package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.*;
import com.symbio.sbtm.model.dao.*;

@Service("IDurationService")
public class DurationService implements IDurationService {

	@Autowired
	private IDurationDao durationDao;

	@Override
	@Transactional
	public void save(Duration duration) throws Exception {
		durationDao.save(duration);
	}

	@Override
	@Transactional
	public void delete(Duration duration) throws Exception {
		durationDao.delete(duration);
	}

	@Override
	@Transactional
	public void update(Duration duration) throws Exception {
		durationDao.update(duration);
	}

	@Override
	public Duration getDurationByName(String name) throws Exception {
		return durationDao.getDurationByName(name);
	}

	@Override
	public List<Duration> getAllDurations() throws Exception {
		return durationDao.getAllDurations();
	}

}
