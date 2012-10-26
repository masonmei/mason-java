package org.personal.mason.job.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Product;

public class ProductDao extends DAO<Product> {

public ProductDao() {
}

@PersistenceContext
public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

@Override
protected Class<Product> getClazz() {
	return Product.class;
}

public List<Product> findCompanyProducts(Company company, Integer start, Integer length) {
	log.debug("start find entities of class [" + getClazz().getSimpleName() + "]");
	try {
		Session delegate = (Session) entityManager.getDelegate();
		Criteria criteria = delegate.createCriteria(getClazz(), "product");
		criteria.add(Restrictions.eq("product.company", company));
		if (start > 0) {
			criteria.setFirstResult(start);
		}
		if (length > 0) {
			criteria.setMaxResults(length);
		}

		@SuppressWarnings("unchecked")
		final List<Product> result = criteria.list();
		log.debug("end find entities of class [" + getClazz().getSimpleName() + "]");
		return result;
	} catch (HibernateException e) {
		log.debug("exception find entities of class [" + getClazz().getSimpleName() + "]", e);
		return null;
	}
}
}
