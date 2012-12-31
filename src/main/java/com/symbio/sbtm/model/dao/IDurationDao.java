package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.Duration;

public interface IDurationDao {
	public void save(Duration duration) throws Exception;

	public void delete(Duration duration) throws Exception;

	public void update(Duration duration) throws Exception;

	public Duration getDurationByName(String name) throws Exception;

	public List<Duration> getAllDurations() throws Exception;
}
