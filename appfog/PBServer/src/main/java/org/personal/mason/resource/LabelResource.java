package org.personal.mason.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.personal.mason.domain.Label;
import org.personal.mason.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/label")
public class LabelResource {

@Autowired
private LabelService labelService;

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/list")
public List<String> listLabels() {
	List<Label> labels = labelService.findAll();
	List<String> names = new ArrayList<String>();
	for (Label label : labels) {
		names.add(label.getLabelName());
	}
	return names;
}
}
