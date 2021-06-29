package com.glproject.Sir_Hans.dao;


import java.util.List;

public interface DiscussionDao {

	/**
	 * 
	 * @return all discussion threads in the database
	 */
	List<Discussion> getDiscussion();
	
	
	/**
	 * 
	 * @param ID is a primary key
	 * @return the only discussion who has this specific key
	 */
	Discussion getDiscussion(Long ID);


	/**
	 * 
	 * @param thematics
	 * @return all discussion threads who have this specific thematics
	 */
	List<Discussion> getDiscussions(String thematics);
	

	/**
	 * Add a new discussion to the database
	 * 
	 * @param discussion
	 * @return 
	 */
	Discussion addDiscussion(Discussion discussion);
	
	

	void delete(Discussion discussion);


	Discussion addMessageTo(long id);


	Discussion addDiscussionTo(String thematics, Discussion discussion);


	Discussion updateDiscussion(Discussion discussion);


	Discussion deleteDiscussionTo(long parseLong, Discussion discussion);


	Discussion addMessage(String contents);
	

}

