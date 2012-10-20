package org.personal.mason.job.dao;

import javax.persistence.EntityManager;

import org.personal.mason.job.domain.Product;

public class ProductDao extends DAO<Product> {

public ProductDao() {
}

public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

public void setClazz(Class<Product> clazz) {
	this.clazz = clazz;
}
}
