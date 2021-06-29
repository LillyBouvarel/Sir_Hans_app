package com.glproject.Sir_Hans.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.ws.rs.core.Response;

import com.glproject.Sir_Hans.dao.Message;
import com.glproject.Sir_Hans.dao.MessageDao;


public class MessageDaoImpl implements MessageDao {

	private PersistenceManagerFactory pmf;

	public MessageDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getMessages() {
		List<Message> messages = null;
		List<Message> detached = new ArrayList<Message>();

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			Query q = pm.newQuery(Message.class);
			messages = (List<Message>) q.execute();
			messages.toString();
			detached = (List<Message>) pm.detachCopyAll(messages);

			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	@Override
	public Message getMessage(Long ID) {
		Message message = null;
		Message detached = null;

		PersistenceManager pm = pmf.getPersistenceManager();  
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			message = pm.getObjectById(Message.class, ID);
			
			//without this line, items of user are becoming null after the pm.close()
			// weird...
			message.toString();
			
			
			detached = pm.detachCopy(message);
			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getType(String type) {
		List<Message> messages = null;
		List<Message> detached = null;

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			Query q = pm.newQuery(Message.class);
			q.declareParameters("String messagetype");
			
			q.setFilter("type == messagetype");
			
			messages = (List<Message>) q.execute(type);
			detached = (List<Message>) pm.detachCopyAll(messages);
				
			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getAuthor(String author){
		List<Message> messages = null;
		List<Message> detached = null;

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			Query q = pm.newQuery(Message.class);
			q.declareParameters("String messageauthor");
			
			q.setFilter("author == messageauthor");
			
			messages = (List<Message>) q.execute(messages);
			detached = (List<Message>) pm.detachCopyAll(messages);
				
			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getVotes(Long vote){
		List<Message> messages = null;
		List<Message> detached = null;

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			Query q = pm.newQuery(Message.class);
			q.declareParameters("String messagevote");
			
			q.setFilter("vote == messagevote");
			
			messages = (List<Message>) q.execute(messages);
			detached = (List<Message>) pm.detachCopyAll(messages);
				
			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}
	

	@Override
	public Message addMessage(Message message) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		Message detached = new Message();
		
		try {
			tx.begin();
			message = pm.makePersistent(message);
			
			detached = pm.detachCopy(message);
			
			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;

	}


	
	@Override
	public void delete(Message message) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			
			pm.deletePersistent(pm.getObjectById(Message.class, message.getId()));
			
			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	@Override
	public Response deleteMessage(String contents, Message message) {
		// TODO Auto-generated method stub
		return null;
	}

}
 
