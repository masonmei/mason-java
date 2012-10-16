package org.personal.mason.job.service;

import org.personal.mason.job.dao.LabelDao;
import org.personal.mason.job.domain.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("labelService")
public class LabelService extends DefaultService<Label> {

	@Autowired
	private LabelDao labelDao;

	public LabelDao getLabelDao() {
		return labelDao;
	}

	public void setLabelDao(LabelDao labelDao) {
		super.setDao(labelDao);
		this.labelDao = labelDao;
	}

}
