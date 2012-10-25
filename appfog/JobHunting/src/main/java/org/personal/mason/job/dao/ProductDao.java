package org.personal.mason.job.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.personal.mason.job.domain.Product;

public class ProductDao extends DAO<Product> {

private EntityManager entityManager;
public ProductDao() {
}

@PersistenceContext
public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

@Override
protected EntityManager getEntityManager() {
	return entityManager;
}
@Override
protected Class<Product> getClazz() {
	return Product.class;
}
}
