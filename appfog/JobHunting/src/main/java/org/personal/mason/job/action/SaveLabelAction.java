package org.personal.mason.job.action;

import org.personal.mason.job.domain.Label;
import org.personal.mason.job.service.LabelService;

import com.opensymphony.xwork2.ModelDriven;

public class SaveLabelAction extends AbstractAction implements ModelDriven<Label> {

private static final long serialVersionUID = 1530872748085444359L;

private Label label = new Label();
private LabelService labelService;
private String msg;
private boolean success;

public String getMsg() {
	return msg;
}

public boolean isSuccess() {
	return success;
}

public void setLabelService(LabelService labelService) {
	this.labelService = labelService;
}

@Override
public String process() {
	try {
		labelService.save(label);
		msg = "Save Label Success";
		success = true;
	} catch (Exception e) {
		log.debug("save label failed", e);
    }
	return "result";
}

@Override
public Label getModel() {
	return label;
}

}
