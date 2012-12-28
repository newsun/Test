package com.symbio.sbtm.servlet.user.online;

import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUserList implements ServletContextListener,
		HttpSessionListener, HttpSessionAttributeListener {
	private ServletContext app = null;

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		this.app = arg0.getServletContext();
		this.app.setAttribute("online", new TreeSet<Object>());

	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		Set<Object> all = (Set<Object>) (this.app.getAttribute("online"));
		all.add(arg0.getValue());
		this.app.setAttribute("online", all);
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		Set<Object> all = (Set<Object>) (this.app.getAttribute("online"));
		all.remove(arg0.getValue());
		this.app.setAttribute("online", all);
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

}
