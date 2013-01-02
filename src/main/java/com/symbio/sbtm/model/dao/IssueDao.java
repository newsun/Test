package com.symbio.sbtm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.*;

@Repository(value = "IIssueDao")
public class IssueDao implements IIssueDao {

	private static final Logger logger = Logger.getLogger(IssueDao.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Issue issue) {
		entityManager.persist(issue);
	}

	@Override
	public void delete(Issue issue) {
		Issue deleteissue = entityManager.merge(issue);
		entityManager.remove(deleteissue);
	}

	@Override
	public void update(Issue issue) {
		entityManager.merge(issue);
	}

	@Override
	public Issue getIssue(Long issueId) {
		try {
			return entityManager.find(Issue.class, issueId);
		} catch (NoResultException e) {
			logger.warn("No entity found for query charter in issueId: " + issueId);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Issue> getAllIssues(Long charterId) {
		String qlString = "from Issue b where b.charter.id=:cid";
		try {
			return entityManager.createQuery(qlString).setParameter("cid", charterId).getResultList();
		} catch (NoResultException e) {
			logger.warn("No entity found for query charter in charterId: " + charterId);
		}
		return null;
	}
}
