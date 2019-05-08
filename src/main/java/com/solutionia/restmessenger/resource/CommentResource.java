package com.solutionia.restmessenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.solutionia.restmessenger.model.Comment;
import com.solutionia.restmessenger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	CommentService cmtService = new CommentService();
	long msgId;

	public CommentResource() {

	}

	public CommentResource(long msgId) {
		this.msgId=msgId;
	}

	@GET
	public List<Comment> getAllComments() {
		return cmtService.getAllComment(msgId);
	}

	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("commentId") long commentId) {
		return cmtService.getComment(msgId, commentId);
	}
	
	@POST
	public Comment addComment(Comment comment) {
		return cmtService.addComment(msgId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(Comment comment,@PathParam("commentId") long commentId ) {
		comment.setCommentId(commentId);
		return cmtService.updateComment(msgId, comment);
		
	}

}
