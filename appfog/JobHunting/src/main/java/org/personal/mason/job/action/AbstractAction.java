package org.personal.mason.job.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, ServletContextAware {

private static final long serialVersionUID = -3435748590670497867L;
private static final String SESSION_TOKEN = "accountid";

protected final Log log = LogFactory.getLog(this.getClass());

protected HttpServletRequest request;
protected HttpServletResponse response;
protected HttpSession session;
protected ServletContext context;
protected String accountId;

@Override
public void setServletRequest(HttpServletRequest request) {
	this.request = request;
	this.session = request.getSession();
	this.accountId = (String) this.session.getAttribute(SESSION_TOKEN);
}

@Override
public void setServletResponse(HttpServletResponse response) {
	this.response = response;
}

@Override
public void setServletContext(ServletContext context) {
	this.context = context;
}

public abstract String process();

public String execute() {
	if (this.accountId == null) {
		return process();
	} else {
		return null;
	}
}
}
