package org.personal.mason.job.action;

import org.personal.mason.job.service.InterviewService;

public class DeleteInterviewAction extends AbstractAction {

private static final long serialVersionUID = -4701499416685544526L;

private InterviewService interviewService;
private String msg;
private boolean success;

public String getMsg() {
	return msg;
}

public boolean isSuccess() {
	return success;
}

public void setInterviewService(InterviewService interviewService) {
	this.interviewService = interviewService;
}

@Override
public String process() {
	try {
		String parameter = request.getParameter("id");
		if (parameter != null) {
			interviewService.deleteById(Long.parseLong(parameter));
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
