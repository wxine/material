package com.test.material.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.test.material.domain.Project;

@Component
@Transactional
public class ProjectDao {
	@PersistenceContext
	private EntityManager entityManager;

	public Session getSession() {
		return entityManager.unwrap(Session.class);

	}

	public List<Project> findAll() {
		DetachedCriteria dc = DetachedCriteria.forClass(Project.class);
		Criteria criteria = dc.getExecutableCriteria(getSession());
		List<Project> list = criteria.list();
		return list;
	}

	public Project findById(String id) {
		Project project = (Project) getSession().get(Project.class, id);
		return project;
	}

	public List select(String pname,String password) {
		DetachedCriteria dc = DetachedCriteria.forClass(Project.class);
		dc.add(Restrictions.eq("pname", pname));
		dc.add(Restrictions.eq("password", password));
		Criteria criteria = dc.getExecutableCriteria(getSession());
		return criteria.list();
	}

	public void save(Project project) {

		this.getSession().save(project);

	}

	public void delete(Project project) {
		this.getSession().delete(project);
	}

	public void update(Project project) {
		this.getSession().merge(project);
	}

}
