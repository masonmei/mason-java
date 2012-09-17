package org.personal.mason.restful.rest.dao;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.personal.mason.restful.rest.model.Todo;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public enum TodoDao {
instance;

private LoadingCache<String, Todo> contentProvider = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.MINUTES).build(new CacheLoader<String, Todo>(){
	@Override
    public Todo load(String key) throws Exception {
		id = 1;
		init();
		return null;
    }
});
private Integer id = 1;

private TodoDao(){
	init();
}

private void init() {
	Todo todo = new Todo();
	todo.setDescription("Initial Sample Todo");
	saveTodo(todo);
}

public Todo getTodo(String id){
	return contentProvider.apply(id);
}

public void saveTodo(Todo todo){
	String key = id.toString();
	todo.setId(key);
	contentProvider.put(key , todo);
	id++;
}

public Todo updateTodo(Todo todo){
	contentProvider.put(todo.getId() , todo);
	return contentProvider.apply(todo.getId());
}

public Collection<Todo> findAll(){
	return contentProvider.asMap().values();
}
}
