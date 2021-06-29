package com.glproject.Sir_Hans.dao;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * This class represent an accounted user 
 * 
 * @author lilly
 *
 */
@PersistenceCapable
public class User {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	protected Long id = null;

	String name;
	String password;
	

	public User() {
		super();
	}

	public User(String name) {
		super();
		this.name = name;
	}
	
	public User(String name, String password) {
		this(name);
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	/**
	 * return true if the user has this specific password
	 * @param password: the password tested
	 * @return
	 */
	
	public boolean hasPassword(String password) {
		return this.password.equals(password);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		User user = (User) obj;
		return getId().equals(user.getId());
	}
	


}



