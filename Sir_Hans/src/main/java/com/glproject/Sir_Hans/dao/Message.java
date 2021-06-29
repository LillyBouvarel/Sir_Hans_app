package com.glproject.Sir_Hans.dao;

import java.text.DateFormat;
import java.util.Date;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


/**
 * This class represent a message (question or answer) 
 * 
 *@author lilly
 *
 */
@PersistenceCapable
public class Message{

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	protected Long id = null;
	
	String type;
	String author;
	Long vote;
	String contents;
	Date date = new Date();

	public Message () {
		super();
	}
	
	public Message(String author, Long vote, String contents,String type){
		super();
		this.author = author;
		this.type = type;
		this.vote = vote;
		this. contents =  contents; 
	}
	

	public Long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this. contents =  contents; 
	}
	
	public String getType() {
		return type;
	}

	public Long getVote() {
		return vote;
	}

	public void setVote(Long vote) {
		this.vote = vote;
	}
	
	public String date(Date date) {
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		return shortDateFormat.format(date);
	}
	
	public boolean questionOrAnswer(String type) {
		if(this.type.equals(type)) {
			return true;
		}
		else {
			return false;
		}
	}

}



