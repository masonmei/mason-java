package org.personal.mason.job.action;

import org.personal.mason.job.service.JobService;

public class DeleteJobAction extends AbstractAction {

private static final long serialVersionUID = 2230765738252104536L;

private JobService jobService;
private String msg;
private boolean success;

public String getMsg() {
	return msg;
}

public boolean isSuccess() {
	return success;
}

public void setJobService(JobService jobService) {
	this.jobService = jobService;
}

@Override
public String process() {
	try {
		String parameter = request.getParameter("id");
		if (parameter != null) {
			jobService.deleteById(Long.parseLong(parameter));
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
