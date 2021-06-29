package com.glproject.Sir_Hans.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


/**
 * This class represent a discussion thread 
 * 
 *@author lilly
 *
 */
@PersistenceCapable
public class Discussion{

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	protected Long id = null;

	Message question;
	String thematics;
	List<Message> answers;
	

	public Discussion() {
		super();
	}

	public Discussion(Message question, String thematics){
		super();
		this.question = question;
		this.thematics = thematics;
		answers = new ArrayList<Message>();
		
	}
	

	public Long getId() {
		return id;
	}

	public Message getQuestion() {
		return question;
	}

	public void setQuestion(Message question) {
		this.question = question;
	}

	public String getThematics() {
		return thematics;
	}

	public void setThematics(String thematics) {
		this.thematics = thematics;
	}

	public List<Message> getAnswers() {
		return answers;
	}
	
	public void setAnswers(List<Message> answers) {
		this.answers = answers; 
	}

	public void addMessageTo(Message message) {
		answers.add(message);
	}


}



