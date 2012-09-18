package org.personal.mason.restful.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.personal.mason.restful.domain.BaseEntity;

public class DAO<T extends BaseEntity> implements IDAO<T> {

private final Log log = LogFactory.getLog(this.getClass().getSimpleName()+"DAO");
private EntityManager entityManager;

public DAO(EntityManager entityManager){
	this.entityManager = entityManager;
}

@Override
public void save(T entity) {
	log.debug("saving entity " + entity.getClass() + " instance",  null);
	try {
		entityManager.persist(entity);
		log.debug("save successful",  null);
	} catch (RuntimeException re) {
		log.debug("save failed", re);
		throw re;
	}
}

@Override
public T update(T entity) {
	log.debug("updating entity " + entity.getClass() + " instance",  null);
	try {
		T result = entityManager.merge(entity);
		log.debug("update successful",  null);
		return result;
	} catch (RuntimeException re) {
		log.debug("update failed", re);
		throw re;
	}
}

@Override
public T saveOrUpdate(T entity){
	log.debug("saveOrUpdate entity " + entity.getClass() + " instance",  null);
	try {
		T result;
		if(entity.getId() == null){
			entityManager.persist(entity);
			result = entity;
		}else{
			result = entityManager.merge(entity);
		}
		
		log.debug("update successful",  null);
		return result;
	} catch (RuntimeException re) {
		log.debug("update failed", re);
		throw re;
	}
}

@SuppressWarnings("unchecked")
@Override
public void del(T entity) {
	log.debug("updating entity " + entity.getClass() + " instance");
	try {
		entity = (T) entityManager.getReference(entity.getClass(), entity.getId());
		entityManager.remove(entity);
		log.debug("delete successful",  null);
	} catch (RuntimeException re) {
		log.debug("delete failed", re);
		throw re;
	}
}

@Override
public T get(Class<T> clz, Serializable id) {
	log.debug("finding entity " + clz + " instance with id: " + id,  null);
	try {
		T instance = entityManager.find(clz, id);
		return instance;
	} catch (RuntimeException re) {
		log.debug("find failed", re);
		throw re;
	}
}

@SuppressWarnings("unchecked")
@Override
public List<T> getBy(Class<T> clz, String fieldName, Serializable value) {
	Query query = entityManager.createQuery("from " + clz.getName() + " where " + fieldName + "=?");
	query.setParameter(1, value);
	return query.getResultList();
}

@Override
public List<T> query(Class<T> clz, String scope) {
	return query(clz, scope, null);
}

@Override
public List<T> query(Class<T> clz, String scope, Collection<?> params) {
	return query(clz, scope, params, -1, -1);
}

@SuppressWarnings("unchecked")
@Override
public List<T> query(Class<T> clz, String scope, Collection<?> params, int begin, int max) {
	Query query = entityManager.createQuery("from " + clz.getName() + " where " + scope);
	int parameterIndex = 1;
	if (params != null && params.size() > 0) {
		for (Object obj : params) {
			query.setParameter(parameterIndex++, obj);
		}
	}
	if (begin >= 0 && max > 0) {
		query.setFirstResult(begin);
		query.setMaxResults(max);
	}
	return query.getResultList();
}

@Override
public List<T> query(String queryStr) {
	return query(queryStr, null);
}

@Override
public List<T> query(String queryStr, Collection<?> params) {
	return query(queryStr, params, -1, -1);
}

@SuppressWarnings("unchecked")
@Override
public List<T> query(String queryStr, Collection<?> params, int begin, int max) {
	Query query = entityManager.createQuery(queryStr);
	int parameterIndex = 1;
	if (params != null && params.size() > 0) {
		for (Object obj : params) {
			query.setParameter(parameterIndex++, obj);
		}
	}
	if (begin >= 0 && max > 0) {
		query.setFirstResult(begin);
		query.setMaxResults(max);
	}
	return query.getResultList();
}

@Override
public Object uniqueResult(String sql) {
	return uniqueResult(sql, null);
}

@Override
public Object uniqueResult(String sql, Collection<?> params) {
	Query query = entityManager.createQuery(sql);
	int parameterIndex = 1;
	if (params != null && params.size() > 0) {
		for (Object obj : params) {
			query.setParameter(parameterIndex++, obj);
		}
	}
	return query.getSingleResult();
}

@Override
public int execute(String sql) {
	return execute(sql, null);
}

@Override
public int execute(String sql, Collection<?> params) {
	Query query = entityManager.createNativeQuery(sql);
	int parameterIndex = 0;
	if (params != null && params.size() > 0) {
		for (Object obj : params) {
			query.setParameter(parameterIndex++, obj);
		}
	}
	return query.executeUpdate();
}

}
