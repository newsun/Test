package com.symbio.sbtm.model.dao;

import java.util.List;

import com.symbio.sbtm.model.*;

public interface IssueDao {
	public void save(Issue issue);

	public void delete(Issue issue);

	public void update(Issue issue);

	public Issue getIssue(Long IssueId);

	public List<Issue> getAllIssues(Long charterId);
}
