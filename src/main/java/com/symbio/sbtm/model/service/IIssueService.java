package com.symbio.sbtm.model.service;

import java.util.List;

import com.symbio.sbtm.model.*;

public interface IIssueService {
	public void save(Issue issue) ;

	public void delete(Issue issue) ;

	public void update(Issue issue) ;

	public Issue getIssue(Long IssueId) ;

	public List<Issue> getAllIssues(Long charterId) ;
}
