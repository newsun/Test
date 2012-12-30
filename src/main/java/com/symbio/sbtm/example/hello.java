package com.symbio.sbtm.example;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.symbio.sbtm.model.User;
import com.symbio.sbtm.model.service.UserService;

public class hello extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
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
		if (user != null && user.getUserId() != null) {
			try {
				user = userService.getUserByUserId(user.getUserId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return this.SUCCESS;
	}

	public String throwSecurityException() throws Exception {
		return "SecurityBreachException";
	}

	// @Override
	// public void validate() {
	// if (null == user || user.getUserId() == null) {
	// return;
	// } else if (user.toString().length() == 0) {
	// // addFieldError("user.name", "User Name cannot be empty");
	// // this.addActionError("Action Failed!!!");
	// }
	// // super.validate();
	// }
}
