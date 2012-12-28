package com.symbio.sbtm.ui.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.symbio.sbtm.vo.User;

public class LoginInterceptor_bak extends MethodFilterInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {

		// ActionContext is defined to obtain session ,request, response objects
		// below is to the method for general functions to obtain
		// HttpServletRequest and HttpServletResponse in
		ActionContext actionContext = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) actionContext
				.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) actionContext
				.get(ServletActionContext.HTTP_RESPONSE);
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";

		// obtain session. check whether use login in.
		// return null is used to avoid login repeatedly
		User user = (User) actionContext.getSession().get("login");
		if (user == null) {
			// return "login" if not login, redirect this page.
			response.sendRedirect(basePath + "index.jsp");
			return null;
		}
		return ai.invoke();
	}

}
