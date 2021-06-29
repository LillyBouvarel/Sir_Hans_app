package com.glproject.Sir_Hans.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import com.glproject.Sir_Hans.dao.impl.DiscussionDaoImpl;
import com.glproject.Sir_Hans.dao.impl.MessageDaoImpl;
import com.glproject.Sir_Hans.dao.impl.UserDaoImpl;

public class DAO {
	
	
	static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Glproject");
	
	public static PersistenceManagerFactory getPmf() {
		return pmf;
	}
	
	public static UserDao getUserDao() {
		return new UserDaoImpl(pmf);
	}
	
	public static MessageDao getMessageDao() {
		return new MessageDaoImpl(pmf);
	}
	
	public static DiscussionDao getDiscussionDao() {
		return new DiscussionDaoImpl(pmf);
	}
	

}
