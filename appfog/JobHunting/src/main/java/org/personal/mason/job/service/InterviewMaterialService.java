package org.personal.mason.job.service;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.InterviewMaterialDao;
import org.personal.mason.job.domain.InterviewMaterial;

public class InterviewMaterialService extends DefaultService<InterviewMaterial> {
private InterviewMaterialDao interviewMaterialDao;

public InterviewMaterialDao getInterviewMaterialDao() {
	return interviewMaterialDao;
}

public void setInterviewMaterialDao(InterviewMaterialDao interviewMaterialDao) {
	this.interviewMaterialDao = interviewMaterialDao;
}

@Override
public DAO<InterviewMaterial> getDao() {
	return interviewMaterialDao;
}

}
