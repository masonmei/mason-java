package org.personal.mason.job.service;

import org.personal.mason.job.dao.InterviewMaterialDao;
import org.personal.mason.job.domain.InterviewMaterial;

public class InterviewMaterialService extends DefaultService<InterviewMaterial> {
private InterviewMaterialDao interviewMaterialDao;

public InterviewMaterialDao getInterviewMaterialDao() {
	return interviewMaterialDao;
}

public void setInterviewMaterialDao(InterviewMaterialDao interviewMaterialDao) {
	super.setDao(interviewMaterialDao);
	this.interviewMaterialDao = interviewMaterialDao;
}

}
