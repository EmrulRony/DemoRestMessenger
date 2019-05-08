package com.solutionia.restmessenger.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.solutionia.restmessenger.model.Link;
import com.solutionia.restmessenger.model.Message;
import com.solutionia.restmessenger.resource.beans.MessageFilterBean;
import com.solutionia.restmessenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService msgService = new MessageService();

	@GET
	// All the params are bundled into a cless named MessageFilterBean
	public List<Message> getAllMessages(@BeanParam MessageFilterBean filterBean) {

		if (filterBean.getYear() > 0) {
			return msgService.getMessageByYear(filterBean.getYear());
		}
		if (filterBean.getStart() >=0 && filterBean.getSize() >0 && filterBean.getSize()<=msgService.getAllMessages().size()) {
			return msgService.paginatedMessage(filterBean.getStart(), filterBean.getSize());
		}
		return msgService.getAllMessages();
	}
	
	// implementing HATEOAS

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		Message msg=msgService.getMessage(id);
		URI uriSelf = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(Long.toString(id))
				.build();
		URI uriComment = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource")
				.resolveTemplate("messageId", msg.getId())
				.build();
		List <Link> links = msg.getLinks();
				links.add(new Link(uriSelf.toString(),"self"));
				links.add(new Link(uriComment.toString(),"comment"));
		return msg;
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return msgService.updateMessage(message);
	}

//	@POST
//	public Message addMessage(Message message) {
//		return msgService.addMessage(message);
	
//	}
	@POST
	// Sending custom response
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message messageNew = msgService.addMessage(message);
		URI uri=uriInfo.getAbsolutePathBuilder().path(Long.toString(messageNew.getId())).build();
		return Response.created(uri)
//				.status(Status.CREATED)
				.entity(messageNew)
				.build();
	}

	@DELETE
	@Path("/{messageId}")
	public Message delMessage(@PathParam("messageId") long id) {
		return msgService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(@PathParam("messageId") long msgId) {
		return new CommentResource(msgId);
	}

}
