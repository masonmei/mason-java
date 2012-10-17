package org.personal.mason.job.action;

import java.util.List;

import org.personal.mason.job.domain.InterviewMaterial;
import org.personal.mason.job.service.InterviewMaterialService;

public class GetInterviewMaterialsAction extends AbstractAction {

private static final long serialVersionUID = -8962937884725321514L;
private InterviewMaterialService interviewMaterialService;
private List<InterviewMaterial> interviewMaterials;
private int page;
private int pageSize;

public List<InterviewMaterial> getInterviewMaterials() {
	return interviewMaterials;
}

public void setInterviewMaterialService(InterviewMaterialService interviewMaterialService) {
	this.interviewMaterialService = interviewMaterialService;
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
			interviewMaterials = interviewMaterialService.findAll();
		} else {
			interviewMaterials = interviewMaterialService.findInScope(page * pageSize, pageSize);
		}
		return SUCCESS;
	} catch (Exception e) {
		log.debug("cannot get interviewMaterials", e);
	}
	return null;
}

}
