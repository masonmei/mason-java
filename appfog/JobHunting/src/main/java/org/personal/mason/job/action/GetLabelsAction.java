package org.personal.mason.job.action;

import java.util.List;

import org.personal.mason.job.domain.Label;
import org.personal.mason.job.service.LabelService;

public class GetLabelsAction extends AbstractAction {

private static final long serialVersionUID = -6738401651001110462L;

private LabelService labelService;
private List<Label> labels;
private int page;
private int pageSize;

public List<Label> getLabels() {
	return labels;
}

public void setLabelService(LabelService labelService) {
	this.labelService = labelService;
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
			labels = labelService.findAll();
		} else {
			labels = labelService.findInScope(page * pageSize, pageSize);
		}

		return SUCCESS;
	} catch (Exception e) {
		log.debug("cannot get labels", e);
	}
	return null;
}

}
