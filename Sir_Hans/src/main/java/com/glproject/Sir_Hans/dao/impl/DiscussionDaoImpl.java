package com.glproject.Sir_Hans.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.glproject.Sir_Hans.dao.Discussion;
import com.glproject.Sir_Hans.dao.DiscussionDao;


public class DiscussionDaoImpl implements DiscussionDao {

	private PersistenceManagerFactory pmf;

	public DiscussionDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Discussion> getDiscussion() {
		List<Discussion> discussions = null;
		List<Discussion> detached = new ArrayList<Discussion>();

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			Query q = pm.newQuery(Discussion.class);
			discussions = (List<Discussion>) q.execute();
			discussions.toString();
			detached = (List<Discussion>) pm.detachCopyAll(discussions);

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
	public Discussion getDiscussion(Long ID) {
		Discussion discussion = null;
		Discussion detached = null;

		PersistenceManager pm = pmf.getPersistenceManager();  
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			discussion = pm.getObjectById(Discussion.class, ID);
			
			//without this line, items of user are becoming null after the pm.close()
			// weird...
			discussion.toString();
			
			
			detached = pm.detachCopy(discussion);
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
	public List<Discussion> getDiscussions(String thematics) {
		List<Discussion> discussions = null;
		List<Discussion> detached = null;

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			Query q = pm.newQuery(Discussion.class);
			q.declareParameters("String discussionthematics");
			
			q.setFilter("thematics == discussionthematics");
			
			discussions = (List<Discussion>) q.execute(thematics);
			detached = (List<Discussion>) pm.detachCopyAll(discussions);
				
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
	public Discussion addDiscussion(Discussion discussion) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		Discussion detached = new Discussion();
		
		try {
			tx.begin();
			discussion = pm.makePersistent(discussion);
			
			detached = pm.detachCopy(discussion);
			
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
	public void delete(Discussion discussion) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			
			pm.deletePersistent(pm.getObjectById(Discussion.class, discussion.getId()));
			
			tx.commit();

		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	@Override
	public Discussion addMessageTo(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discussion addDiscussionTo(String thematics, Discussion discussion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discussion updateDiscussion(Discussion discussion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discussion deleteDiscussionTo(long parseLong, Discussion discussion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discussion addMessage(String contents) {
		// TODO Auto-generated method stub
		return null;
	}

}

