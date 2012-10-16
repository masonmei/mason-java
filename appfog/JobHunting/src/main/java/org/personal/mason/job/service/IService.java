package org.personal.mason.job.service;

import java.io.Serializable;
import java.util.Collection;

public interface IService<T> {

	public T findById(Serializable id);
	
	public Collection<T> findAll();
	
	public Collection<T> findInScope(int start, int length);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public void save(T entity);
}
