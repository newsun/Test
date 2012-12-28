/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.symbio.sbtm.ui.action.login;

import java.util.ArrayList;
import java.util.Date;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.model.User;

@SuppressWarnings("serial")
@Conversion()
public class CheckUserAction extends ActionSupport {

	private Date now;
	private String name;
	private String password;

	@TypeConversion(converter = "com.symbio.sbtm.ui.action.login.DateConverter")
	// @RequiredFieldValidator(message = "Please enter the date")
	public void setDateNow(Date now) {
		this.now = now;
	}

	@TypeConversion(converter = "com.symbio.sbtm.ui.action.login.DateConverter")
	public Date getDateNow() {
		return now;
	}

	@RequiredStringValidator(message = "Please enter username", trim = true)
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@RequiredStringValidator(message = "Please enter password", trim = true)
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public String execute() throws Exception {
		User user_ = new User();
		user_.setUserId(this.name);
		user_.setPassword(this.password);
		user_.setValid(true);
		ArrayList<User> users = DAOFactory.getUserDAO().getUser(user_);
		if (users == null || users.size() != 1) {
			this.addFieldError("msg", "Invalid username or password");
			return this.INPUT;
		} else
			return SUCCESS;
	}
}
