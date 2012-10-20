package org.personal.mason.job.dao;

import javax.persistence.EntityManager;

import org.personal.mason.job.domain.News;

public class NewsDao extends DAO<News> {

public NewsDao() {
}

public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
}

public void setClazz(Class<News> clazz) {
	this.clazz = clazz;
}
}
