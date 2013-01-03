package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.*;
import com.symbio.sbtm.model.dao.*;

@Service("durationService")
public class DurationServiceImpl implements DurationService {

	@Autowired
	private DurationDao durationDao;

	@Override
	@Transactional
	public void save(Duration duration)  {
		durationDao.save(duration);
	}

	@Override
	@Transactional
	public void delete(Duration duration)  {
		durationDao.delete(duration);
	}

	@Override
	@Transactional
	public void update(Duration duration)  {
		durationDao.update(duration);
	}

	@Override
	public Duration getDurationByName(String name)  {
		return durationDao.getDurationByName(name);
	}

	@Override
	public List<Duration> getAllDurations()  {
		return durationDao.getAllDurations();
	}

}
