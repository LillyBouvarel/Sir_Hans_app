package com.glproject.Sir_Hans.dao;

import java.util.List;

import javax.ws.rs.core.Response;

public interface MessageDao {

	/**
	 * 
	 * @return all messages in the database
	 */
	List<Message> getMessages();
	
	
	/**
	 * 
	 * @param ID is a primary key
	 * @return the only message who has this specific key
	 */
	Message getMessage(Long ID);


	/**
	 * 
	 * @param type
	 * @return all messages who have this specific type
	 */
	List<Message> getType(String type);
	
	/**
	 * 
	 * @param author
	 * @return all messages who have this specific  author's name
	 */
	List<Message> getAuthor(String author);
	
	/**
	 * 
	 * @param vote
	 * @return all messages who have this specific  vote
	 */
	List<Message> getVotes(Long vote);
	

	/**
	 * Add a new message to the database
	 * 
	 * @param message
	 * @return 
	 */
	Message addMessage(Message message);
	
	

	void delete(Message message);


	Response deleteMessage(String contents, Message message);
	

}


