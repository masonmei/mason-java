package org.personal.mason.job.service;

import org.personal.mason.job.dao.LabelDao;
import org.personal.mason.job.domain.Label;

public class LabelService extends DefaultService<Label> {

private LabelDao labelDao;

public LabelDao getLabelDao() {
	return labelDao;
}

public void setLabelDao(LabelDao labelDao) {
	super.setDao(labelDao);
	this.labelDao = labelDao;
}

}
