package org.personal.mason.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.personal.mason.domain.InterviewMaterial;
import org.personal.mason.service.InterviewMaterialService;
import org.personal.mason.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@Path("/material")
public class InterviewMaterialResource {
@Autowired
private InterviewMaterialService interviewMaterialService;

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/list")
public List<InterviewMaterial> listInterviewMaterial(@QueryParam("page") Integer startIndex,
		@QueryParam("size") Integer pageSize) {
	if (startIndex == null || startIndex < 0) {
		startIndex = 0;
	}

	if (pageSize == null || pageSize <= 0) {
		pageSize = 10;
	}

	Page<InterviewMaterial> interviewMaterials = interviewMaterialService.findInScope(startIndex, pageSize);
	return CollectionUtils.pageToList(interviewMaterials);
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/save")
public InterviewMaterial saveInterviewMaterial(InterviewMaterial interviewMaterial) {
	return interviewMaterialService.save(interviewMaterial);
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/get")
public InterviewMaterial viewInterviewMaterial(@QueryParam("id") String id) {
	return interviewMaterialService.findById(id);
}

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/delete")
public void deleteInterviewMaterial(@QueryParam("id") String id) {
	interviewMaterialService.delete(id);
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/answer")
public String getAnswer(@QueryParam("id") String id) {
	InterviewMaterial findById = interviewMaterialService.findById(id);
	return findById.getAnswer();
}
}
