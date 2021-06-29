package com.glproject.Sir_Hans.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.glproject.Sir_Hans.dao.DAO;
import com.glproject.Sir_Hans.dao.Discussion;
import com.glproject.Sir_Hans.dao.Message;



@Path("/Discussion")
public class DiscussionResource {
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create/{thematics}")
	public Response createDiscussion(@PathParam("thematics") String thematics, Discussion discussion) {

		Discussion detached = DAO.getDiscussionDao().addDiscussionTo(thematics, discussion);
		
		return Response.ok(detached).build();		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Message getMessage(@PathParam("id") String id) {
		long messageid = Long.parseLong(id);
		
		Message message = DAO.getMessageDao().getMessage(messageid);
		
		return message;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/add/message")
	public Response addMessageTo(@PathParam("id") String id, Message message) {
		
		Discussion discussion = DAO.getDiscussionDao().getDiscussion(Long.parseLong(id));
		discussion.addMessageTo(message);
		discussion = DAO.getDiscussionDao().updateDiscussion(discussion);
		
		return Response.ok(discussion).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Discussion removeDiscussion(@PathParam("id") String id, Discussion discussion) {
		return DAO.getDiscussionDao().deleteDiscussionTo(Long.parseLong(id), discussion);
	}
	

}


