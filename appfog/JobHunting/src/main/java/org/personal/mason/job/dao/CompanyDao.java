package org.personal.mason.job.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Label;

public class CompanyDao extends DAO<Company> {

public CompanyDao() {
}

public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

public void setClazz(Class<Company> clazz) {
	this.clazz = clazz;
}

public List<Company> findByLabel(Label label, int start, int length) {
	log.debug("start find entities of class [" + clazz.getSimpleName() + "]");
	try {
		Session delegate = (Session) entityManager.getDelegate();
		Criteria criteria = delegate.createCriteria(clazz, "com");
		criteria.createAlias("com.companyLabels", "cls");
		criteria.add(Restrictions.eq("cls.label", label));
		if (start > 0) {
			criteria.setFirstResult(start);
		}
		if (length > 0) {
			criteria.setMaxResults(length);
		}

		@SuppressWarnings("unchecked")
		final List<Company> result = criteria.list();
		log.debug("end find entities of class [" + clazz.getSimpleName() + "]");
		return result;
	} catch (HibernateException e) {
		log.debug("exception find entities of class [" + clazz.getSimpleName() + "]", e);
		return null;
	}
}

}
