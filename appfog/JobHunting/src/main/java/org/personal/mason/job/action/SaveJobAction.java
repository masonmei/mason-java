package org.personal.mason.job.action;

import org.personal.mason.job.domain.Job;
import org.personal.mason.job.service.JobService;

import com.opensymphony.xwork2.ModelDriven;

public class SaveJobAction extends AbstractAction implements ModelDriven<Job> {

private static final long serialVersionUID = 4860071280426910060L;

private Job job = new Job();
private JobService jobService;
private String msg;
private boolean success;

public String getMsg() {
	return msg;
}

public boolean isSuccess() {
	return success;
}

public void setJobService(JobService jobService) {
	this.jobService = jobService;
}

@Override
public String process() {
	try {
		jobService.save(job);
		msg = "Save Job Success";
		success = true;
	} catch (Exception e) {
		log.debug("save job failed", e);
	}
	return "result";
}

@Override
public Job getModel() {
	return job;
}

}
