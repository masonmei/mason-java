package org.personal.mason.job.service;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.JobDao;
import org.personal.mason.job.domain.Job;

public class JobService extends DefaultService<Job> {

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
