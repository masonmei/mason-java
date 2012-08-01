package org.personal.mason.pb.server.api;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.personal.mason.pb.server.api.model.PBAccount;
import org.personal.mason.pb.server.api.model.PBRelation;

@Path("/pbservice/")
public interface PBService {

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/account/create")
public PBAccount createAccount(PBAccount account, @Context HttpServletResponse response);

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/account/validate")
public PBAccount validateAccount(PBAccount account, @Context HttpServletResponse response);

@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/account/modify")
public PBAccount modifyAccount(PBAccount account, @Context HttpServletResponse response);

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/relation/list")
public Set<PBRelation> listRelations(@HeaderParam("Token") String token);

@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/relation/add")
public PBRelation addRelation(PBRelation relation, @HeaderParam("Token") String token);

@PUT
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/relation/modify")
public PBRelation modifyRelation(PBRelation relation, @HeaderParam("Token") String token);

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/relation/delete/{id}")
public boolean deleteRelation(@PathParam("id") Long id, @HeaderParam("Token") String token);

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/record/delete/{id}")
public boolean deleteRecord(@PathParam("id") Long id, @HeaderParam("Token") String token);

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/resource/delete/{id}")
public boolean deleteResource(@PathParam("id") Long id, @HeaderParam("Token") String token);

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/relation/retrieve/{type}/{value}")
public Set<PBRelation> getRelations(@PathParam("type") String type,
        @PathParam("value") String value,
        @HeaderParam("Token") String token);

@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/relation/retrieve/{type}")
public Set<PBRelation> getRelations(@PathParam("type") String type,
        @QueryParam("title") String title,
        @QueryParam("value") String value,
        @HeaderParam("Token") String token);

}
