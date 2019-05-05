package com.solutionia.restmessenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Message {
	private long id;
	private String message;
	private String autor;
	private Date created;
	
	public Message() {
		
	}
	
	public Message(long id, String message, String autor) {
		super();
		this.id = id;
		this.message = message;
		this.autor = autor;
		this.created = new Date();
	}
	// Getter and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
