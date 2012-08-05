package org.personal.mason.gae.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/json/hello")
public class HelloService {
@GET
@Path("/get")
@Produces(MediaType.APPLICATION_JSON)
public String getStringInJSON() {
	return "Hello";

}
}
