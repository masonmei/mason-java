package org.personal.mason.job.action;

import org.personal.mason.job.domain.Interview;
import org.personal.mason.job.service.InterviewService;

import com.opensymphony.xwork2.ModelDriven;

public class SaveInterviewAction extends AbstractAction implements ModelDriven<Interview> {

private static final long serialVersionUID = 3056619879087995786L;

private Interview interview = new Interview();
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
		interviewService.save(interview);
		msg = "Save Interview Success";
		success = true;
	} catch (Exception e) {
		log.debug("save interview failed", e);
	}
	return "result";
}

@Override
public Interview getModel() {
	return interview;
}

}
