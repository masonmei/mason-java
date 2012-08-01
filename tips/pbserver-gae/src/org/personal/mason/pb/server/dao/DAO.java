package org.personal.mason.pb.server.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.personal.mason.pb.server.conf.EntityManagerHelper;
import org.personal.mason.pb.server.domain.BaseEntity;

public class DAO<T extends BaseEntity> implements IDAO<T> {

private EntityManager getEntityManager() {
	return EntityManagerHelper.getEntityManager();
}

@Override
public void save(T entity) {
	EntityManagerHelper.log("saving entity " + entity.getClass() + " instance", Level.INFO, null);
	try {
		getEntityManager().persist(entity);
		EntityManagerHelper.log("save successful", Level.INFO, null);
	} catch (RuntimeException re) {
		EntityManagerHelper.log("save failed", Level.SEVERE, re);
		throw re;
	}
}

@Override
public T update(T entity) {
	EntityManagerHelper.log("updating entity " + entity.getClass() + " instance", Level.INFO, null);
	try {
		T result = getEntityManager().merge(entity);
		EntityManagerHelper.log("update successful", Level.INFO, null);
		return result;
	} catch (RuntimeException re) {
		EntityManagerHelper.log("update failed", Level.SEVERE, re);
		throw re;
	}
}

@Override
public T saveOrUpdate(T entity){
	EntityManagerHelper.log("saveOrUpdate entity " + entity.getClass() + " instance", Level.INFO, null);
	try {
		T result;
		if(entity.getId() == null){
			getEntityManager().persist(entity);
			result = entity;
		}else{
			result = getEntityManager().merge(entity);
		}
		
		EntityManagerHelper.log("update successful", Level.INFO, null);
		return result;
	} catch (RuntimeException re) {
		EntityManagerHelper.log("update failed", Level.SEVERE, re);
		throw re;
	}
}

@SuppressWarnings("unchecked")
@Override
public void del(T entity) {
	EntityManagerHelper.log("updating entity " + entity.getClass() + " instance", Level.INFO, null);
	try {
		entity = (T) getEntityManager().getReference(entity.getClass(), entity.getId());
		getEntityManager().remove(entity);
		EntityManagerHelper.log("delete successful", Level.INFO, null);
	} catch (RuntimeException re) {
		EntityManagerHelper.log("delete failed", Level.SEVERE, re);
		throw re;
	}
}

@Override
public T get(Class<T> clz, Serializable id) {
	EntityManagerHelper.log("finding entity " + clz + " instance with id: " + id, Level.INFO, null);
	try {
		T instance = getEntityManager().find(clz, id);
		return instance;
	} catch (RuntimeException re) {
		EntityManagerHelper.log("find failed", Level.SEVERE, re);
		throw re;
	}
}

@SuppressWarnings("unchecked")
@Override
public List<T> getBy(Class<T> clz, String fieldName, Serializable value) {
	Query query = getEntityManager().createQuery("from " + clz.getName() + " where " + fieldName + "=?");
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
	Query query = getEntityManager().createQuery("from " + clz.getName() + " where " + scope);
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
	Query query = getEntityManager().createQuery(queryStr);
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
	Query query = getEntityManager().createQuery(sql);
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
	Query query = getEntityManager().createNativeQuery(sql);
	int parameterIndex = 0;
	if (params != null && params.size() > 0) {
		for (Object obj : params) {
			query.setParameter(parameterIndex++, obj);
		}
	}
	return query.executeUpdate();
}

}
