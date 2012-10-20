package org.personal.mason.job.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.personal.mason.job.domain.ProductCategory;

public class ProductCategoryDao extends DAO<ProductCategory> {

public ProductCategoryDao() {
}

public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

public void setClazz(Class<ProductCategory> clazz) {
	this.clazz = clazz;
}

public List<ProductCategory> getProductCategoryRoots() {
	log.debug("start find entities of class [" + clazz.getSimpleName() + "]");
	try {
		Session delegate = (Session) entityManager.getDelegate();
		Criteria criteria = delegate.createCriteria(clazz, "pc");
		criteria.add(Restrictions.isNull("pc.productCategory"));

		@SuppressWarnings("unchecked")
		final List<ProductCategory> result = criteria.list();
		log.debug("end find entities of class [" + clazz.getSimpleName() + "]");
		return result;
	} catch (HibernateException e) {
		log.debug("exception find entities of class [" + clazz.getSimpleName() + "]", e);
		return null;
	}
}

public List<ProductCategory> getProduCategoryChildren(ProductCategory productCategory) {
	log.debug("start find entities of class [" + clazz.getSimpleName() + "]");
	try {
		Session delegate = (Session) entityManager.getDelegate();
		Criteria criteria = delegate.createCriteria(clazz, "pc");
		criteria.add(Restrictions.eq("pc.productCategory", productCategory));

		@SuppressWarnings("unchecked")
		final List<ProductCategory> result = criteria.list();
		log.debug("end find entities of class [" + clazz.getSimpleName() + "]");
		return result;
	} catch (HibernateException e) {
		log.debug("exception find entities of class [" + clazz.getSimpleName() + "]", e);
		return null;
	}
}

}
