package com.symbio.sbtm.dao.impl;

import java.util.ArrayList;

import com.symbio.sbtm.dao.IIssue;
import com.symbio.sbtm.utils.util;
import com.symbio.sbtm.vo.Charter;
import com.symbio.sbtm.vo.Issue;

public class IssueImpl implements IIssue {

	public void doCreate(Issue issue) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doDelete(Issue issue) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doUpdate(Issue issue) throws Exception {
		// TODO Auto-generated method stub

	}

	public Issue getIssue(Issue issue) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Issue> getAllIssues(Charter charter) throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<Issue>) util.getAllObjects(Issue.class, Charter.class, charter);
	}

}
