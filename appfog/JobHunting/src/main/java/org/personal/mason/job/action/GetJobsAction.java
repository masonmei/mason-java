package org.personal.mason.job.action;

import java.util.List;

import org.personal.mason.job.domain.Job;
import org.personal.mason.job.service.JobService;

public class GetJobsAction extends AbstractAction {

private static final long serialVersionUID = -2596713199193296511L;
private JobService jobService;
private List<Job> jobs;
private int page;
private int pageSize;

public List<Job> getJobs() {
	return jobs;
}

public void setJobService(JobService jobService) {
	this.jobService = jobService;
}

public void setPage(int page) {
	this.page = page;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

@Override
public String process() {
	try {
		if (pageSize <= 0 || page < 0) {
			jobs = jobService.findAll();
		} else {
			jobs = jobService.findInScope(page * pageSize, pageSize);
		}
		
		return SUCCESS;
	} catch (Exception e) {
		log.debug("cannot get jobs", e);
	}
	return null;
}

}
