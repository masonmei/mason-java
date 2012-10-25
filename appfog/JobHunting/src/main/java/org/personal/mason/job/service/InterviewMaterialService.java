package org.personal.mason.job.service;

import javax.annotation.Resource;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.InterviewMaterialDao;
import org.personal.mason.job.domain.InterviewMaterial;
import org.springframework.stereotype.Service;
@Service
public class InterviewMaterialService extends DefaultService<InterviewMaterial> {

@Resource
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
