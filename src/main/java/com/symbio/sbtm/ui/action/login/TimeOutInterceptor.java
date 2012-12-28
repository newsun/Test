package com.symbio.sbtm.ui.action.login;

import java.util.Map;

//import com.opensymphony.xwork2.ActionInvocation;
//import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
//
//public class TimeOutInterceptor extends MethodFilterInterceptor {
//
//	@Override
//	protected String doIntercept(ActionInvocation invocation) throws Exception {
//		Map<String, Object> sessionMap = invocation.getInvocationContext()
//				.getSession();
//		Object username = sessionMap.get("username");
//		if (username == null)
//			return "timeout";
//		else
//			return invocation.invoke();
//	}
//
//}

public class TimeOutInterceptor {
}