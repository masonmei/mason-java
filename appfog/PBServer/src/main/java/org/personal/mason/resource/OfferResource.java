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

import org.personal.mason.domain.Offer;
import org.personal.mason.service.OfferService;
import org.personal.mason.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@Path("/offer")
public class OfferResource {
@Autowired
private OfferService offerService;

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/list")
public List<Offer> listOffer(@QueryParam("page") Integer startIndex, @QueryParam("size") Integer pageSize) {
	if (startIndex == null || startIndex < 0) {
		startIndex = 0;
	}

	if (pageSize == null || pageSize <= 0) {
		pageSize = 10;
	}

	Page<Offer> offers = offerService.findInScope(startIndex, pageSize);
	return CollectionUtils.pageToList(offers);
}

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/save")
public Offer saveOffer(Offer offer) {
	return offerService.save(offer);
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/get")
public Offer viewOffer(@QueryParam("id") String id) {
	return offerService.findById(id);
}

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/delete")
public void deleteOffer(@QueryParam("id") String id) {
	offerService.delete(id);
}

}
