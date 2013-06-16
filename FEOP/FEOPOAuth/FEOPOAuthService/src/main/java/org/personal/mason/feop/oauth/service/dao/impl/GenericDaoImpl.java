package org.personal.mason.feop.oauth.service.dao.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.personal.mason.feop.oauth.service.dao.GenericDao;

public class GenericDaoImpl<T> implements GenericDao<T> {
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		if (entityManager == null) {
			throw new IllegalArgumentException("entityManager cannot be null");
		}
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager.getEntityManagerFactory().createEntityManager();
	}

	/**
	 * @see org.appfuse.dao.DAO#saveObject(java.lang.Object)
	 */
	public void saveObject(T entity) {
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
	}

	/**
	 * @see org.appfuse.dao.DAO#getObject(java.lang.Class, java.io.Serializable)
	 */
	public T getObject(Class<T> clazz, Serializable id) {
		try {
			return getEntityManager().find(clazz, id);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @see org.appfuse.dao.DAO#getObjects(java.lang.Class)
	 */
	public List<T> getObjects(Class<T> clazz) {
		try {
			EntityManager entityManager = getEntityManager();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<T> criteria = criteriaBuilder.createQuery(clazz);
			Root<T> root = criteria.from(clazz);
			criteria.select(root);
			return entityManager.createQuery(criteria).getResultList();
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

	/**
	 * @see org.appfuse.dao.DAO#removeObject(java.lang.Class,
	 *      java.io.Serializable)
	 */
	public void removeObject(Class<T> clazz, Serializable id) {
		T entity = getObject(clazz, id);
		removeObject(entity);
	}

	@Override
	public void removeObject(T entity) {
		if (entity != null) {
			getEntityManager().remove(entity);
		}
	}

	/**
	 * @param str
	 * @return boolean
	 */
	public boolean isNullOrSpace(String str) {
		if (str != null && !str.trim().equals("") && !str.trim().equals("null")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @param o
	 * @return boolean
	 */
	public boolean isNullOrSpace(Object o) {
		if (o != null && !o.toString().equals("")) {
			return false;
		} else {
			return true;
		}
	}

}
