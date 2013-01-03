package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.Duration;

public interface DurationDao {
	public void save(Duration duration) ;

	public void delete(Duration duration) ;

	public void update(Duration duration) ;

	public Duration getDurationByName(String name) ;

	public List<Duration> getAllDurations() ;
}
