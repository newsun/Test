package com.symbio.sbtm.example;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.symbio.sbtm.model.User;
import com.symbio.sbtm.model.service.UserService;

public class hello extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	@Autowired
	private transient UserService userService;

	public ArrayList<String> listExample;

	public ArrayList<String> getListExample() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("option1");
		list.add("option2");
		list.add("option3");
		return list;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {

		return SUCCESS;
	}

	public String throwSecurityException() throws Exception {
		return "SecurityBreachException";
	}

	@Override
	public void validate() {
		this.getFieldErrors().clear();
		this.getActionErrors().clear();
		if (user == null || user.getUserId() == null||user.getUserId().equals("")) {
			addFieldError("user.userId", "User id cannot be empty");
			this.addActionError("Action Failed!!!");

		} else {
			user = userService.getUserByUserId(user.getUserId());
			if (null == user) {
				addFieldError("user.userId", "User id is invalid");
				this.addActionError("Action Failed!!!");
			}
		}
		super.validate();
	}
}
