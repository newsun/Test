package com.symbio.sbtm.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logout
 */
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public logout() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		response.setHeader("refresh", "5;URL=login");
		PrintWriter out = response.getWriter();
		out.println(getPageSrc());
		out.close();
		ServletContext context = super.getServletContext();
		Set<Object> all = (Set<Object>) context.getAttribute("online");
		Iterator iter = all.iterator();
		System.out.print("Online User List:");
		while (iter.hasNext()) {
			System.out.print(iter.next().toString());
		}
		System.out.println();
	}

	private String getPageSrc() {
		return "<html><head>"
				+ "<style>body { font-family: Tahoma, Verdana, Arial, sans-serif; }</style>"
				+ "<title>Session-Based Test Management</title>"
				+ "</head><body>"
				+ "<h4 align='center'>Successfully logout from SBTM</h4>"
				+ "<div align='center'>Jumping to <a href='login'>relogin</a></div>"
				+ "</body></html>";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
