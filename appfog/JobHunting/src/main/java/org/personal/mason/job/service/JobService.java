package org.personal.mason.job.service;

import java.util.List;

import javax.annotation.Resource;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.JobDao;
import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Job;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

public List<Job> findCompanyJobs(Company company) {
	return findCompanyJobs(company, -1, -1);
}

@Transactional(readOnly = true)
public List<Job> findCompanyJobs(Company company, Integer start, Integer length) {
	return jobDao.findComanyJobs(company, start, length);
}

}
