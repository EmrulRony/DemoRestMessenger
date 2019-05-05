package com.solutionia.restmessenger.message;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.solutionia.restmessenger.model.Message;
import com.solutionia.restmessenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService msgService = new MessageService();
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getMessage() {
//		return "Congrats, this is ur first rest api!";
//	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages(){
		return msgService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId")long id) {
		return msgService.getMessage(id);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id,Message message) {
		message.setId(id);
		return msgService.updateMessage(message);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return msgService.addMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message delMessage(@PathParam("messageId")long id) {
		return msgService.removeMessage(id);
	}
	

}
