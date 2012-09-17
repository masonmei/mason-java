package org.personal.mason.restful.rest.resources;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.personal.mason.restful.rest.dao.TodoDao;
import org.personal.mason.restful.rest.model.Todo;

@Path("todo")
public class TodoResource {

@GET
@Path("/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Todo getTodo(@PathParam("id") String id) {
	return TodoDao.instance.getTodo(id);
}

@GET
@Path("/list")
@Produces(MediaType.APPLICATION_JSON)
public Collection<Todo> getTodos() {
	return TodoDao.instance.findAll();
}

@POST
@Path("/add")
@Consumes(MediaType.APPLICATION_JSON)
public void addTodo(Todo todo){
	TodoDao.instance.saveTodo(todo);
}

@POST
@Path("/update")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Todo updateTodo(Todo todo){
	return TodoDao.instance.updateTodo(todo);
}
}
