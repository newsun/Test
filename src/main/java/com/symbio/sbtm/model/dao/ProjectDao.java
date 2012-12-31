package com.symbio.sbtm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.OS;
import com.symbio.sbtm.model.Project;

@Repository(value = "IProjectDao")
public class ProjectDao implements IProjectDao {

	private static final Logger logger = Logger.getLogger(IProjectDao.class.getName());

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(Project project) throws Exception {
		entityManager.persist(project);
	}

	@Override
	public void delete(Project project) throws Exception {
		Project deleteproject = entityManager.merge(project);
		entityManager.remove(deleteproject);
	}

	@Override
	public void update(Project project) throws Exception {
		entityManager.merge(project);
	}

	@Override
	public Project getProjectByName(String name) throws Exception {
		String qlString = "from " + Project.class.getSimpleName() + " as pro where pro.name='" + name + "'";
		Query query = entityManager.createQuery(qlString);
		try {
			return (Project) query.getSingleResult();
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllProjects() throws Exception {
		String qlString = "from " + OS.class.getSimpleName();
		return entityManager.createQuery(qlString).getResultList();
	}
}
