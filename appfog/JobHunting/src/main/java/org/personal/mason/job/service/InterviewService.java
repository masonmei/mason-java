package org.personal.mason.job.service;

import org.personal.mason.job.dao.InterviewDao;
import org.personal.mason.job.domain.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("interviewSerivce")
public class InterviewService extends DefaultService<Interview> {

	@Autowired
	private InterviewDao interviewDao;

	public InterviewDao getInterviewDao() {
		return interviewDao;
	}

	public void setInterviewDao(InterviewDao interviewDao) {
		super.setDao(interviewDao);
		this.interviewDao = interviewDao;
	}

}
