package com.symbio.sbtm.ui.action.login;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.symbio.sbtm.vo.User;

public class LoginInterceptor implements Interceptor {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	public void destroy() {
		System.out.println("Interceptor destroyed");
	}

	public void init() {
		System.out.println("Interceptor initialized");

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Interceptor stared");
		if (LoginAction.class == invocation.getAction().getClass()) {
			return invocation.invoke();
		}
		User user = (User) invocation.getInvocationContext().getSession()
				.get("user");
		if (user == null)
			return "fail";
		System.out.println("User loggined in");
		return invocation.invoke();
	}

}
