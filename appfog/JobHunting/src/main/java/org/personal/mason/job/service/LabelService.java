package org.personal.mason.job.service;

import java.util.List;

import javax.annotation.Resource;

import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.LabelDao;
import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Label;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class LabelService extends DefaultService<Label> {

@Resource
private LabelDao labelDao;

public LabelDao getLabelDao() {
	return labelDao;
}

public void setLabelDao(LabelDao labelDao) {
	this.labelDao = labelDao;
}

@Override
public DAO<Label> getDao() {
	return labelDao;
}

@Transactional(readOnly = true)
public Label findByLabelName(String labelName) {
	return labelDao.findByLabelName(labelName);
}

@Transactional(readOnly = true)
public List<Label> findByCompany(Company company){
	return labelDao.findByCompany(company);
}
}
