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

import org.personal.mason.domain.Interview;
import org.personal.mason.service.InterviewService;
import org.personal.mason.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@Path("/interview")
public class InterviewResource {
@Autowired
private InterviewService interviewService;

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/list")
public List<Interview> listInterview(@QueryParam("page") Integer startIndex, @QueryParam("size") Integer pageSize) {
	if (startIndex == null || startIndex < 0) {
		startIndex = 0;
	}

	if (pageSize == null || pageSize <= 0) {
		pageSize = 10;
	}

	Page<Interview> interviews = interviewService.findInScope(startIndex, pageSize);
	return CollectionUtils.pageToList(interviews);
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/save")
public Interview saveInterview(Interview interview) {
	return interviewService.save(interview);
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/get")
public Interview viewInterview(@QueryParam("id") String id) {
	return interviewService.findById(id);
}

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/delete")
public void deleteInterview(@QueryParam("id") String id) {
	interviewService.deleteById(id);
}
}
