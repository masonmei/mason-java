package org.personal.mason.resource;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.personal.mason.utils.LocationUtils;

@Path("/common")
public class CommonResource {

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cities")
public List<String> getCitiesOfProvince(@QueryParam("provinceName") String provinceName) {
	List<String> citiesOfProvince = LocationUtils.getCitiesOfProvince(provinceName);
	return Collections.unmodifiableList(citiesOfProvince);
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/province")
public List<String> getProvinces() {
	return Collections.unmodifiableList(LocationUtils.getAllProvince());
}
}
