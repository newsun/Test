package com.symbio.sbtm.model.dao;

import java.util.ArrayList;

import com.symbio.sbtm.model.Duration;

public interface IDuration {
	public void doCreate(Duration duration) throws Exception;

	public void doDelete(Duration duration) throws Exception;

	public void doUpdate(Duration duration) throws Exception;

	public ArrayList<Duration> getDuration(Duration duration) throws Exception;

	public ArrayList<Duration> getAllDurations() throws Exception;
}
