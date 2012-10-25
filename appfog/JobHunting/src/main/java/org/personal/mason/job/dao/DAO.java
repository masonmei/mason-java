package org.personal.mason.job.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

public abstract class DAO<T> implements IDAO<T> {

protected final Log log = LogFactory.getLog(this.getClass().getSimpleName());

protected abstract EntityManager getEntityManager();
protected abstract Class<T> getClazz();

public T findById(Serializable id) {
	log.debug("start find entity [" + getClazz().getSimpleName() + "] with id [" + id + "]");
	try {
		final T result = getEntityManager().find(getClazz(), id);
		log.debug("end find entity [" + getClazz().getSimpleName() + "] with id [" + id + "]");
		return result;
	} catch (Exception e) {
		log.debug("exception while find entity [" + getClazz().getSimpleName() + "] with id [" + id + "]", e);
	}
	return null;
}

public List<T> findAll() {
	return findByCriteria(-1, -1);
}

public List<T> findInScope(int start, int length) {
	return findByCriteria(start, length);
}

private List<T> findByCriteria(int start, int length) {
	log.debug("start find entities of class [" + getClazz().getSimpleName() + "]");
	try {
		Session delegate = (Session) getEntityManager().getDelegate();
		Criteria criteria = delegate.createCriteria(getClazz());
		if (start >= 0) {
			criteria.setFirstResult(start);
		}
		if (length > 0) {
			criteria.setMaxResults(length);
		}
		@SuppressWarnings("unchecked")
		final List<T> result = criteria.list();
		log.debug("end find entities of class [" + getClazz().getSimpleName() + "]");
		return result;
	} catch (HibernateException e) {
		log.debug("exception find entities of class [" + getClazz().getSimpleName() + "]", e);
		return null;
	}
}

public List<T> findByExample(T exampleInstance) {
	return findByExample(exampleInstance, -1, -1);
}

public List<T> findByExample(T exampleInstance, int start, int length) {
	log.debug("start find entities of class [" + getClazz().getSimpleName() + "] by example [" + exampleInstance + "]");
	try {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(getClazz());
		Example example = Example.create(exampleInstance);
		criteria.add(example);
		if (start > 0) {
			criteria.setFirstResult(start);
		}
		if (length > 0) {
			criteria.setMaxResults(length);
		}

		@SuppressWarnings("unchecked")
		final List<T> result = criteria.list();
		log.debug("end find entities of class [" + getClazz().getSimpleName() + "] by example [" + exampleInstance + "]");
		return result;
	} catch (HibernateException e) {
		log.debug("exception find entities of class [" + getClazz().getSimpleName() + "] by example [" + exampleInstance + "]", e);
		return null;
	}

}

public List<T> findByNamedQuery(String name, Object... params) {
	log.debug("start find entities of class [" + getClazz().getSimpleName() + "] with named query [" + name + "]");
	try {
		Query query = getEntityManager().createNamedQuery(name);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}

		@SuppressWarnings("unchecked")
		final List<T> result = (List<T>) query.getResultList();
		log.debug("end find entities of class [" + getClazz().getSimpleName() + "] with named query [" + name + "]");
		return result;
	} catch (Exception e) {
		log.debug("exception find entities of class [" + getClazz().getSimpleName() + "] with named query [" + name + "]", e);
		return null;
	}
}

public List<T> findByNamedQueryAndNamedParams(String name, Map<String, ? extends Object> params) {
	log.debug("start find entities of class [" + getClazz().getSimpleName() + "] with named query and named param [" + name + "]");
	try {
		Query query = getEntityManager().createNamedQuery(name);

		for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		@SuppressWarnings("unchecked")
		final List<T> result = (List<T>) query.getResultList();
		log.debug("start find entities of class [" + getClazz().getSimpleName() + "] with named query and named param [" + name + "]");
		return result;
	} catch (Exception e) {
		log.debug("start find entities of class [" + getClazz().getSimpleName() + "] with named query and named param [" + name + "]", e);
		return null;
	}
}

public long countAll() {
	try {
		final StringBuffer quertStr = new StringBuffer("SELECT count(o) from ");
		quertStr.append(getClazz().getSimpleName()).append(" o ");
		final Query query = getEntityManager().createQuery(quertStr.toString());
		return (Long) query.getSingleResult();
	} catch (Exception e) {
		return -1;
	}
}

public long countByExample(String exampleInstance) {
	Session session = (Session) getEntityManager().getDelegate();
	Criteria criteria = session.createCriteria(getClazz());
	Example example = Example.create(exampleInstance);
	criteria.add(example);
	@SuppressWarnings("rawtypes")
	List list = criteria.list();
	if (list != null)
		return list.size();
	return -1;
}

public void save(T entity) {
	log.debug("start save entity [" + entity + "]");
	try {
		getEntityManager().persist(entity);
		log.debug("end delete entity [" + entity + "]");
	} catch (Exception e) {
		log.debug("exception delete entity [" + entity + "]");
	}
}

public void udpate(T entity) {
	log.debug("start update entity [" + entity + "]");
	try {
		getEntityManager().merge(entity);
		log.debug("end update entity [" + entity + "]");
	} catch (Exception e) {
		log.debug("exception delete entity [" + entity + "]");
	}
}

public void delete(T entity) {
	log.debug("exception delete entity [" + entity + "]");
	try {
		getEntityManager().remove(entity);
		log.debug("exception delete entity [" + getClazz() + "]");
	} catch (Exception e) {
		log.debug("exception delete entity [" + getClazz() + "]", e);
	}
}

public void deleteById(Serializable id) {
	log.debug("start delete entity [" + getClazz() + "] by id [" + id + "]");
	try {
		getEntityManager().remove(findById(id));
		log.debug("end delete entity [" + getClazz() + "] by id [" + id + "]");
	} catch (Exception e) {
		log.debug("exception delete entity [" + getClazz() + "] by id [" + id + "]", e);
	}
}

}
