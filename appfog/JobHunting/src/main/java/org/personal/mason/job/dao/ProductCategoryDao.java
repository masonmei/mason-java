package org.personal.mason.job.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.personal.mason.job.domain.ProductCategory;
import org.springframework.transaction.annotation.Transactional;

public class ProductCategoryDao extends DAO<ProductCategory> {

public ProductCategoryDao() {
}

@PersistenceContext
public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

@Override
protected Class<ProductCategory> getClazz() {
	return ProductCategory.class;
}

@Transactional(readOnly=true)
public List<ProductCategory> getProductCategoryRoots() {
	log.debug("start find entities of class [" + getClazz().getSimpleName() + "]");
	try {
		Session delegate = (Session) entityManager.getDelegate();
		Criteria criteria = delegate.createCriteria(getClazz(), "pc");
		criteria.add(Restrictions.isNull("pc.productCategory"));

		@SuppressWarnings("unchecked")
		final List<ProductCategory> result = criteria.list();
		log.debug("end find entities of class [" + getClazz().getSimpleName() + "]");
		return result;
	} catch (HibernateException e) {
		log.debug("exception find entities of class [" + getClazz().getSimpleName() + "]", e);
		return null;
	}
}

@Transactional(readOnly=true)
public List<ProductCategory> getProduCategoryChildren(ProductCategory productCategory) {
	log.debug("start find entities of class [" + getClazz().getSimpleName() + "]");
	try {
		Session delegate = (Session) entityManager.getDelegate();
		Criteria criteria = delegate.createCriteria(getClazz(), "pc");
		criteria.add(Restrictions.eq("pc.productCategory", productCategory));

		@SuppressWarnings("unchecked")
		final List<ProductCategory> result = criteria.list();
		log.debug("end find entities of class [" + getClazz().getSimpleName() + "]");
		return result;
	} catch (HibernateException e) {
		log.debug("exception find entities of class [" + getClazz().getSimpleName() + "]", e);
		return null;
	}
}

}
