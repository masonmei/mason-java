package org.personal.mason.job.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.personal.mason.job.domain.Label;

public class LabelDao extends DAO<Label> {

public LabelDao() {
}

@PersistenceContext
public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

@Override
protected Class<Label> getClazz() {
	return Label.class;
}

public Label findByLabelName(String labelName) {
	log.debug("start find entities of class [" + getClazz().getSimpleName() + "]");
	try {
		Session delegate = (Session) entityManager.getDelegate();
		Criteria criteria = delegate.createCriteria(getClazz());
		criteria.add(Restrictions.eq("labelName", labelName));
		log.debug("end find entities of class [" + getClazz().getSimpleName() + "]");
		return (Label) criteria.uniqueResult();
	} catch (HibernateException e) {
		log.debug("exception find entities of class [" + getClazz().getSimpleName() + "]", e);
		return null;
	}
}

}
