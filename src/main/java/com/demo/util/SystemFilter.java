package com.demo.util;

import org.apache.log4j.Logger;

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



public class SystemFilter implements Filter {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SystemFilter.class);

	private static String[] EXCEPT_URL = new String[]{"login.htm" ,"signsystem/selectjyglsignpage.htm","sys/loginNew.htm" ,"sxzz/a1.htm" ,"dologin.htm","sys/error.htm"};  

	public void init(FilterConfig config) throws ServletException {}

	public void destroy() {}
		
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession(true);
//		if(checkUrl(req)){
//			Bas_user user = (Bas_user) session.getAttribute("login_user");
//			if (user == null) {
//				String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/login.htm";
//				resp.sendRedirect(basePath);
//			} else {
//				chain.doFilter(request, response);
//			}
//		} else {
//			chain.doFilter(request, response);
//		}
		//chain.doFilter(request, response);
		logger.info("------->URL:" + req.getRequestURI());
		//System.out.println("------->URL:"+req.getRequestURI());
	}

	private boolean checkUrl(HttpServletRequest req) {
		for(String obj:EXCEPT_URL) {
			if(req.getRequestURI().indexOf(obj)>0) {
				return false;
			}
		}
		return true;
	}
}
