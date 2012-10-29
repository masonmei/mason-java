package org.personal.mason.job.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.personal.mason.job.domain.Province;

public class ProvinceDao extends DAO<Province> {

public ProvinceDao() {
}

@PersistenceContext
public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

@Override
protected Class<Province> getClazz() {
	return Province.class;
}

public Province findByProvinceName(String province) {
	log.debug("start find entities of class [" + getClazz().getSimpleName() + "]");
	try {
		Session delegate = (Session) entityManager.getDelegate();
		Criteria criteria = delegate.createCriteria(getClazz());
		criteria.add(Restrictions.eq("provinceName", province));
		log.debug("end find entities of class [" + getClazz().getSimpleName() + "]");
		return (Province) criteria.uniqueResult();
	} catch (HibernateException e) {
		log.debug("exception find entities of class [" + getClazz().getSimpleName() + "]", e);
		return null;
	}
}

}
