package org.personal.mason.job.service;

import java.io.Serializable;
import java.util.List;

public interface IService<T> {

	public T findById(Serializable id);
	
	public List<T> findAll();
	
	public List<T> findInScope(int start, int length);
	
	public List<T> findByExample(final T instance);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public void deleteById(Serializable id);
	
	public void save(T entity);
}
