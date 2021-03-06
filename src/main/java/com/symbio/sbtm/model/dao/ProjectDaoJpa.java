package com.symbio.sbtm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.symbio.sbtm.model.Project;

@Repository(value = "projectDao")
public class ProjectDaoJpa implements ProjectDao {

	private static final Logger logger = Logger.getLogger(ProjectDaoJpa.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Project project) {
		entityManager.persist(project);
	}

	@Override
	public void delete(Project project) {
		Project deleteproject = entityManager.merge(project);
		entityManager.remove(deleteproject);
	}

	@Override
	public void update(Project project) {
		entityManager.merge(project);
	}

	@Override
	public Project getProjectByName(String name) {
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
	public List<Project> getAllProjects() {
		String qlString = "from " + Project.class.getSimpleName();
		return entityManager.createQuery(qlString).getResultList();
	}

	@Override
	public Project getProjectById(Long projectId) {
		String qlString = "from " + Project.class.getSimpleName() + " as pro where pro.id=:id";
		Query query = entityManager.createQuery(qlString).setParameter("id", projectId);
		return (Project) query.getSingleResult();
	}

	@Override
	public Project getProject(Project project) {
		String qlString = "from " + Project.class.getSimpleName() + " as pro where ";
		if (project.getId() != null)
			qlString += "pro.id=" + project.getId();
		else if (project.getName() != null)
			qlString += "pro.name=" + project.getName();
		return (Project) entityManager.createQuery(qlString).getSingleResult();
	}
}
