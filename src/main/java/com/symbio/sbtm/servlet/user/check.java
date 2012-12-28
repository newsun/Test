package com.symbio.sbtm.servlet.user;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class check
 */
public class check implements Filter {
	private String charset;

	/**
	 * Default constructor.
	 */
	public check() {
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getServletPath();
		HttpSession ses = req.getSession();
		if (ses.getAttribute("userid") != null) {
			chain.doFilter(request, response);
		} else if (path.equals("/login") || path.equals("/logout")
				|| path.equals("/login.jsp")) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect("login");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.charset = fConfig.getInitParameter("charset");
		// System.out.println("Using charset: " + this.charset);
	}

}
