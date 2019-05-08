package com.solutionia.restmessenger.database;

import java.util.HashMap;
import java.util.Map;

import com.solutionia.restmessenger.model.Comment;
import com.solutionia.restmessenger.model.Message;
import com.solutionia.restmessenger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long,Message> messages = new HashMap<>();
	private static Map<String,Profile> profiles = new HashMap<>();
	private static Map<Long,Comment> comments = new HashMap<>();
	
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static void setMessages(Map<Long, Message> messages) {
		DatabaseClass.messages = messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	public static void setProfiles(Map<String, Profile> profiles) {
		DatabaseClass.profiles = profiles;
	}
	public static Map<Long, Comment> getComments() {
		return comments;
	}
	public static void setComments(Map<Long, Comment> comments) {
		DatabaseClass.comments = comments;
	}

}
