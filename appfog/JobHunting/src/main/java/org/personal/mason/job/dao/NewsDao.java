package org.personal.mason.job.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.personal.mason.job.domain.News;

public class NewsDao extends DAO<News> {

public NewsDao() {
}

@PersistenceContext
public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

@Override
protected Class<News> getClazz() {
	return News.class;
}
}
