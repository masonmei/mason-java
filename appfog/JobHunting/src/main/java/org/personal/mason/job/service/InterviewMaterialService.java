package org.personal.mason.job.service;

import org.personal.mason.job.dao.InterviewMaterialDao;
import org.personal.mason.job.domain.InterviewMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("interviewMaterialService")
public class InterviewMaterialService extends DefaultService<InterviewMaterial> {
	@Autowired
	private InterviewMaterialDao interviewMaterialDao;

	public InterviewMaterialDao getInterviewMaterialDao() {
		return interviewMaterialDao;
	}

	public void setInterviewMaterialDao(InterviewMaterialDao interviewMaterialDao) {
		super.setDao(interviewMaterialDao);
		this.interviewMaterialDao = interviewMaterialDao;
	}

}
