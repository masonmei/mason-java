package org.personal.mason.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.personal.mason.utils.Constants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RestLoginInterceptor implements HandlerInterceptor {

@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	String uri = request.getRequestURI();
	if (!uri.contains("/account/create") && !uri.endsWith("/account/create")) {
		String header = request.getHeader(Constants.REST_TOKEN_KEY);
		if (header == null) {
			return false;
		}
	}
	return true;
}

@Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {

}

@Override
public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
		throws Exception {

}

}
