package org.personal.mason.job.service;

import org.personal.mason.job.dao.JobDao;
import org.personal.mason.job.domain.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jobService")
public class JobService extends DefaultService<Job> {

	@Autowired
	private JobDao jobDao;

	public JobDao getJobDao() {
		return jobDao;
	}

	public void setJobDao(JobDao jobDao) {
		super.setDao(jobDao);
		this.jobDao = jobDao;
	}

}
