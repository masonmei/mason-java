package org.personal.mason.feop.oauth.service.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T> {
	
    /**
     * Generic method used to get all objects of a particular type. This
     * is the same as lookup up all rows in a table.
     * @param clazz the type of objects (a.k.a. while table) to get data from
     * @return List of populated objects
     */
    public abstract List<T> getObjects(Class<T> clazz);
    
    /**
     * Generic method to get an object based on class and identifier. An 
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param clazz model class to lookup
     * @param id the identifier (primary key) of the class
     * @return a populated object
     * @see org.springframework.orm.ObjectRetrievalFailureException
     */
    public abstract T getObject(Class<T> clazz, Serializable id);

    /**
     * Generic method to save an object - handles both update and insert.
     * @param o the object to save
     */
    public abstract void saveObject(T entity);

    /**
     * Generic method to delete an object based on class and id
     * @param clazz model class to lookup
     * @param id the identifier (primary key) of the class
     */
    public abstract void removeObject(Class<T> clazz, Serializable id);
    
    public abstract void removeObject(T entity);

}
