package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.Bug;

public interface IBugDao {
	public void save(Bug bug);

	public void delete(Bug bug);

	public void update(Bug bug);

	public Bug getBug(Long bugId);

	public List<Bug> getAllBugs(Long charterId);
}
