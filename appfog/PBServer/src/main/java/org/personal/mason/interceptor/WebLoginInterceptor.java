package org.personal.mason.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.personal.mason.utils.Constants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class WebLoginInterceptor implements HandlerInterceptor {

@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	String uri = request.getRequestURI();
	if (!uri.contains("/resources/") && !uri.endsWith("login") && !uri.endsWith("register") && !uri.endsWith("logout") && !uri.endsWith("index")
			&& !uri.endsWith("validationCode")) {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute(Constants.SESSION_TOKEN);
		if (email == null) {
			response.sendRedirect(uri.substring(0, uri.indexOf("web/")) + "web/index");
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
