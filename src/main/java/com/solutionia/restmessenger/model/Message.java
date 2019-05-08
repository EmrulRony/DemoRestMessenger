package com.solutionia.restmessenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@XmlRootElement
public class Message {
	private long id;
	private String message;
	private String autor;
	private Date created;
	@XmlTransient
	private Map<Long,Comment> comments= new HashMap<>();
	
	private List<Link> links = new ArrayList<Link>();
	
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
	
	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
//	public void addLink(String lnk, String rel) {
//		Link link = new Link(lnk,rel);
//		
//	}
	
}
