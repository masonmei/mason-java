package org.personal.mason.job.service;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.InterviewDao;
import org.personal.mason.job.domain.Interview;
import org.springframework.stereotype.Service;
@Service
public class InterviewService extends DefaultService<Interview> {

private InterviewDao interviewDao;

public InterviewDao getInterviewDao() {
	return interviewDao;
}

public void setInterviewDao(InterviewDao interviewDao) {
	this.interviewDao = interviewDao;
}

@Override
public DAO<Interview> getDao() {
	return interviewDao;
}

}
