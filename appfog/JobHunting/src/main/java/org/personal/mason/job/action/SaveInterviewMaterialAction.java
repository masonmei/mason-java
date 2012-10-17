package org.personal.mason.job.action;

import org.personal.mason.job.domain.InterviewMaterial;
import org.personal.mason.job.service.InterviewMaterialService;

import com.opensymphony.xwork2.ModelDriven;

public class SaveInterviewMaterialAction extends AbstractAction implements ModelDriven<InterviewMaterial> {

private static final long serialVersionUID = -2848076385147835042L;
private InterviewMaterial interviewMaterial = new InterviewMaterial();
private InterviewMaterialService interviewMaterialService;
private String msg;
private boolean success;

public String getMsg() {
	return msg;
}

public boolean isSuccess() {
	return success;
}

public void setInterviewMaterialService(InterviewMaterialService interviewMaterialService) {
	this.interviewMaterialService = interviewMaterialService;
}

@Override
public String process() {
	try {
		interviewMaterialService.save(interviewMaterial);
		msg = "Save InterviewMaterial Success";
		success = true;
	} catch (Exception e) {
		log.debug("save interviewMaterial failed", e);
	}
	return "result";
}

@Override
public InterviewMaterial getModel() {
	return interviewMaterial;
}

}
