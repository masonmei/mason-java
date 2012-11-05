package org.personal.mason.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.personal.mason.utils.Constants;

public class AuthenticationFilter implements Filter {

@Override
public void init(FilterConfig filterConfig) throws ServletException {

}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
		ServletException {
	HttpServletRequest servletRequest = (HttpServletRequest)request;
	HttpServletResponse servletResponse = (HttpServletResponse)response;
	String uri = servletRequest.getRequestURI();
	if (uri.contains("/account/create") || uri.endsWith("/account/create") || uri.contains("/account/index") ) {
		chain.doFilter(servletRequest, response);
		return;
	}
	
	String header = servletRequest.getHeader(Constants.REST_TOKEN_KEY);
	if (header != null) {
		chain.doFilter(servletRequest, response);
		return;
	}
	
	servletResponse.sendRedirect(uri.substring(0, uri.indexOf("rest/")) + "rest/account/index");
	return;
}

@Override
public void destroy() {
	// TODO Auto-generated method stub

}

}
