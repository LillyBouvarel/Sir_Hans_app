package com.glproject.Sir_Hans.ws;


import java.util.List;

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


@Path("/Message")
public class MessageResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Message getMessage(@PathParam("id") String id) {
		long messageid = Long.parseLong(id);
		
		Message message = DAO.getMessageDao().getMessage(messageid);
		
		return message;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{type}")
	public List<Message> getType(@PathParam("type") String type) {
		
		List<Message> messages = DAO.getMessageDao().getType(type);
		
		return messages;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{author}")
	public List<Message> getAuthor(@PathParam("author") String author) {
		
		List<Message> messages = DAO.getMessageDao().getAuthor(author);
		
		return messages;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{vote}")
	public List<Message> getVote(@PathParam("vote") String vote) {
		long messagevote = Long.parseLong(vote);
		
		List<Message> messages = DAO.getMessageDao().getVotes(messagevote);
		
		return messages;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create/{date}")
	public Response createMessage(@PathParam("date") String contents, Message message) {

		Discussion detached = DAO.getDiscussionDao().addMessage(contents);
		
		return Response.ok(detached).build();		
	}

	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{date}")
	public Response removeMessage(@PathParam("date") String contents, Message message) {
		return DAO.getMessageDao().deleteMessage(contents, message);
	}
	

}


