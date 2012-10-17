package org.personal.mason.job.action;

import org.personal.mason.job.service.InterviewMaterialService;

public class DeleteInterviewMaterialAction extends AbstractAction {

private static final long serialVersionUID = 8591542831260876466L;

private InterviewMaterialService interviewMaterialService;
private String msg;
private boolean success;

public String getMsg() {
	return msg;
}

public boolean isSuccess() {
	return success;
}

public void setInterviewMaterialService(InterviewMaterialService interviewMaterialService) {
	this.interviewMaterialService = interviewMaterialService;
}

@Override
public String process() {
	try {
	    String parameter = request.getParameter("id");
	    if (parameter != null) {
	    	interviewMaterialService.deleteById(Long.parseLong(parameter));
	    	msg = "delete success";
	    	success = true;
	    	return SUCCESS;
	    }
	    msg = "nothing to delete";
	    success = true;
    } catch (NumberFormatException e) {
	    log.debug("delete failed", e);
    }
	return null;
}

}
