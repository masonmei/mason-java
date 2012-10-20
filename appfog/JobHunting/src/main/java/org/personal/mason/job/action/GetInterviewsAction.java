package org.personal.mason.job.action;

import java.util.List;

import org.personal.mason.job.domain.Interview;
import org.personal.mason.job.service.InterviewService;

public class GetInterviewsAction extends AbstractAction {

private static final long serialVersionUID = -8922806175669774748L;

private InterviewService interviewService;
private List<Interview> interviews;
private int page;
private int pageSize;

public List<Interview> getInterviews() {
	return interviews;
}

public void setInterviewService(InterviewService interviewService) {
	this.interviewService = interviewService;
}

public void setPage(int page) {
	this.page = page;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

@Override
public String process() {
	try {
		if (pageSize <= 0 || page < 0) {
			interviews = interviewService.findAll();
		} else {
			interviews = interviewService.findInScope(page * pageSize, pageSize);
		}

		return SUCCESS;
	} catch (Exception e) {
		log.debug("cannot get interviews", e);
	}
	return null;
}

}
