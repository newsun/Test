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

import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.vo.User;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println(output(false));
		out.close();
	}

	private String output(boolean b) {
		String htmlsrc = "<html><head>"
				+ "<title>Session-Based Test Management</title>"
				+ "<style>body{ text-align:center;font-family: Tahoma, Verdana, Arial, sans-serif;position: relative;}</style>"
				+ "<SCRIPT language=javascript>document.getElementsByName('userid')[0].focus()</SCRIPT>"
				+ "</head><body>"
				+ "<h3>Login</h3>"
				+ "<div align='center'>"
				+ "<form action='login' method='post'>"
				+ "<table>"
				+ "<tr><td>Username: </td><td><input type='text' name='userid'/></td></tr>"
				+ "<tr><td>Password: </td><td><input type='password' name='pwd'/></td></tr>"
				+ (b ? "<tr ><td colspan='2'><font color='red'>Wrong username or password</font></td><tr>"
						: "")
				+ "<tr><td align='center'><input align='center' type='submit' value='Login'/></td><td align='center'><input align='center' type='reset' value='Reset'/></td></tr>"
				+ "</table></form></div></body></html>";
		return htmlsrc;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		User user = new User();
		user.setPassword(pwd);
		user.setUserId(userid);
		boolean b = false;
		try {
			b = DAOFactory.getUserDAO().getUser(user).get(0).getPassword()
					.equals(pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (b) {
			request.getSession().setAttribute("userid", userid);
			ServletContext context = super.getServletContext();
			Set<Object> all = (Set<Object>) context.getAttribute("online");
			Iterator<Object> iter = all.iterator();
			System.out.print("Online User List:");
			while (iter.hasNext()) {
				System.out.print(iter.next().toString());
			}
			System.out.println();
			response.sendRedirect("index.jsp");
		} else {
			PrintWriter out = response.getWriter();
			out.println(output(true));
			out.close();
		}
	}
}
