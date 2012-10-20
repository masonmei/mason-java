package org.personal.mason.job.service;

import java.io.Serializable;
import java.util.List;

import org.personal.mason.job.dao.DAO;
import org.springframework.transaction.annotation.Transactional;

public abstract class DefaultService<T> implements IService<T> {

public abstract DAO<T> getDao();

@Override
public T findById(Serializable id) {
	return getDao().findById(id);
}

@Override
public List<T> findAll() {
	return getDao().findAll();
}

@Override
public List<T> findInScope(int start, int length) {
	return getDao().findInScope(start, length);
}

public List<T> findByExample(final T instance) {
	return getDao().findByExample(instance);
}

@Override
@Transactional
public void update(T entity) {
	getDao().udpate(entity);
}

@Override
@Transactional
public void delete(T entity) {
	getDao().delete(entity);
}

@Override
@Transactional
public void deleteById(Serializable id) {
	getDao().deleteById(id);
}

@Override
@Transactional
public void save(T entity) {
	getDao().save(entity);
}

}
