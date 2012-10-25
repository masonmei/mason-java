package org.personal.mason.job.service;

import javax.annotation.Resource;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.JobDao;
import org.personal.mason.job.domain.Job;
import org.springframework.stereotype.Service;
@Service
public class JobService extends DefaultService<Job> {

@Resource
private JobDao jobDao;

public JobDao getJobDao() {
	return jobDao;
}

public void setJobDao(JobDao jobDao) {
	this.jobDao = jobDao;
}

@Override
public DAO<Job> getDao() {
	return jobDao;
}

}
