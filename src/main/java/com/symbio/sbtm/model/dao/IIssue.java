package com.symbio.sbtm.model.dao;

import java.util.ArrayList;

import com.symbio.sbtm.model.Charter;
import com.symbio.sbtm.model.Issue;

public interface IIssue {
	public void doCreate(Issue issue) throws Exception;

	public void doDelete(Issue issue) throws Exception;

	public void doUpdate(Issue issue) throws Exception;

	public Issue getIssue(Issue issue) throws Exception;

	public ArrayList<Issue> getAllIssues(Charter charter) throws Exception;
}
