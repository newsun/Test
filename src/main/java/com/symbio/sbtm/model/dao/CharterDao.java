package com.symbio.sbtm.model.dao;

//import java.util.List;
import com.symbio.sbtm.model.*;

public interface CharterDao {
	public void save(Charter charter);

	public void delete(Charter charter);

	public void update(Charter charter);

	public Charter getCharter(long charterId);

	// public List<Bug> getBugs();
	//
	// public List<Issue> getIssues();
	//
	// public List<OS> getOSs();
	//
	// public List<Strategy> getStrategies();
	//
	// public List<DataFile> getDataFiles();
}
