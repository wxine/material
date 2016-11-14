package com.test.material.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.test.material.domain.Material;
import com.test.material.domain.PageUtil;

@Component
@Transactional
public class MaterialDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	public List<Material> findAll() {
		DetachedCriteria dc = DetachedCriteria.forClass(Material.class);
		// dc.add(Restrictions.eq("record", value))
		Criteria criteria = dc.getExecutableCriteria(getSession());
		List<Material> list = criteria.list();

		return list;
	}

	public Material findById(String id) {
		Material material = (Material) getSession().get(Material.class, id);
		return material;
	}

	public void save(Material material) {

		this.getSession().save(material);

	}

	public void delete(Material material) {
		this.getSession().delete(material);
	}

	public void update(Material material) {
		this.getSession().merge(material);
	}

	public PageUtil queryByPage(int page, String keyword) {
		PageUtil pu = new PageUtil();
		DetachedCriteria dc = DetachedCriteria.forClass(Material.class);
		if (keyword != null) {
			Disjunction dis = Restrictions.disjunction();
			dis.add(Property.forName("name").like(keyword, MatchMode.ANYWHERE));
			dis.add(Property.forName("location").like(keyword, MatchMode.ANYWHERE));
			dis.add(Property.forName("parameter").like(keyword, MatchMode.ANYWHERE));
			dc.add(dis);
		}
		dc.addOrder(Order.desc("ctime"));
		Criteria criteria = dc.getExecutableCriteria(getSession());
		pu.setPage(page);
		criteria.setFirstResult((page - 1) * pu.getPagesize());
		criteria.setMaxResults(pu.getPagesize());
		pu.setPagelist(criteria.list());
		pu.setInfototal(Infopage(keyword).intValue());
		pu.setPagetotal(pu.Pages());
		return pu;
	}

	public Long Infopage(String keyword) {
		DetachedCriteria dc = DetachedCriteria.forClass(Material.class);
		if (keyword != null) {
			Disjunction dis = Restrictions.disjunction();
			dis.add(Property.forName("name").like(keyword, MatchMode.ANYWHERE));
			dis.add(Property.forName("location").like(keyword, MatchMode.ANYWHERE));
			dc.add(dis);
		}
		Criteria criteria = dc.getExecutableCriteria(getSession());
		criteria.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();
		return count;
	}
}
