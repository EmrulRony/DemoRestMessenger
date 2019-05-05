package com.solutionia.restmessenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.solutionia.restmessenger.database.DatabaseClass;
import com.solutionia.restmessenger.model.Message;

public class MessageService {
	
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1,"Hello world","Rony"));
		messages.put(2L, new Message(2,"Hello Bangladesh","Emrul"));
		messages.put(3L, new Message(3,"Hello Dhaka","Kayes"));
	}
	
	public List<Message> getAllMessages(){
			
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId()>0) {
			messages.put(message.getId(),message);
			return message;
		}
		
		return null;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
