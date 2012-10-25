package org.personal.mason.job.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.personal.mason.job.domain.News;

public class NewsDao extends DAO<News> {

private EntityManager entityManager;
public NewsDao() {
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
protected Class<News> getClazz() {
	return News.class;
}
}
