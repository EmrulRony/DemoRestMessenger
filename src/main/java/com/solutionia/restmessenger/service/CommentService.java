package com.solutionia.restmessenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.solutionia.restmessenger.database.DatabaseClass;
import com.solutionia.restmessenger.model.Comment;
import com.solutionia.restmessenger.model.Message;

public class CommentService {
	
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	private Map<Long,Comment> comments = DatabaseClass.getComments();
	
	public CommentService() {
		comments.put(1L, new Comment(1, "this is a comment", "Afridi"));
		comments.put(2L, new Comment(2, "this is another comment", "Shaheed"));
	}
	
	public List<Comment> getAllComment(long msgId){
//		comments=messages.get(msgId).getComments();
		
		return new ArrayList<>(comments.values());
	}
	
	public Comment getComment(long msgId, long cmtId) {
//		comments=messages.get(msgId).getComments();
		return comments.get(cmtId);
	}
	
	public Comment addComment (long msgId, Comment comment) {
		comments = messages.get(msgId).getComments();
		
		comment.setCommentId(comments.size()+1);
		return comments.put(comment.getCommentId(), comment);
	}
	
	public Comment updateComment (long msgId, Comment comment) {
		comments =  messages.get(msgId).getComments();
		if (comment.getCommentId()>0) {
			return comments.put(comment.getCommentId(), comment);
		}
		return null;
	}
	
	public Comment removeComment (long msgId, long cmtId) {
		comments = messages.get(msgId).getComments();
		return comments.remove(cmtId);
	}
	
}
