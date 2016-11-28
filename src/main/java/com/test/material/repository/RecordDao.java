package com.test.material.repository;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.test.material.domain.Material;
import com.test.material.domain.Project;
import com.test.material.domain.Record;

@Component
@Transactional
public class RecordDao {
	@PersistenceContext
	private EntityManager entityManager;

	public Session getSession() {
		return entityManager.unwrap(Session.class);

	}

	public void save(Record record) {

		this.getSession().save(record);

	}

	public void update(Record record) {
		this.getSession().update(record);
	}

	public Record findById(String id) {

		Record record = (Record) getSession().get(Record.class, id);
		return record;
	}

	public List<Record> findProject(String id) {
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Record.class);
			dc.add(Restrictions.eq("projectid", id));
			Criteria criteria = dc.getExecutableCriteria(getSession());
			List<Record> list = criteria.list();
			return list;
		} catch (Exception e) {
			throw e;
		}
	}

	public Record findBymaterial(Material material) {
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Record.class);
			dc.add(Restrictions.eq("material", material));
			Criteria criteria = dc.getExecutableCriteria(getSession());
			List<Record> record = criteria.list();
			return record.get(0);
		} catch (Exception e) {
			System.err.println("归还材料方法出错");
			throw e;
		}
	}
}
