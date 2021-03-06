package com.symbio.sbtm.example;

import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;
import com.symbio.sbtm.exceptions.SecurityBreachException;
import com.symbio.sbtm.model.User;

@Repository("ThrowException")
public class ThrowException extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private User user;

	@Override
	public String execute() throws Exception {
		// call Service class to store personBean's state in database
		return SUCCESS;
	}

	public void throwException() throws Exception {
		throw new Exception("Exception thrown from throwException");
	}

	public void throwNullPointerException() throws NullPointerException {
		throw new NullPointerException("Null Pointer Exception thrown from " + ThrowException.class.toString());
	}

	public void throwSecurityException() throws SecurityBreachException {
		throw new SecurityBreachException("Security breach exception thrown from throwSecurityException");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
