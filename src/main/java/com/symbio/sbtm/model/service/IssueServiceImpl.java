package com.symbio.sbtm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.*;
import com.symbio.sbtm.model.dao.*;

@Service("issueService")
public class IssueServiceImpl implements IssueService {

	@Autowired
	private IssueDao issueDao;

	@Override
	@Transactional
	public void save(Issue issue) {
		issueDao.save(issue);
	}

	@Override
	@Transactional
	public void delete(Issue issue) {
		issueDao.delete(issue);
	}

	@Override
	@Transactional
	public void update(Issue issue) {
		issueDao.update(issue);
	}

	@Override
	public Issue getIssue(Long issueId) {
		return issueDao.getIssue(issueId);
	}

	@Override
	public List<Issue> getAllIssues(Long charterId) {
		return issueDao.getAllIssues(charterId);
	}
}
