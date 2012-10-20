package org.personal.mason.job.service;

import org.personal.mason.job.dao.InterviewDao;
import org.personal.mason.job.domain.Interview;

public class InterviewService extends DefaultService<Interview> {

private InterviewDao interviewDao;

public InterviewDao getInterviewDao() {
	return interviewDao;
}

public void setInterviewDao(InterviewDao interviewDao) {
	super.setDao(interviewDao);
	this.interviewDao = interviewDao;
}

}
