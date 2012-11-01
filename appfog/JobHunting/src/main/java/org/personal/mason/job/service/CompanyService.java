package org.personal.mason.job.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.personal.mason.job.dao.CompanyDao;
import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.dao.LabelDao;
import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Label;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService extends DefaultService<Company> {

@Resource
private CompanyDao companyDao;

public CompanyDao getCompanyDao() {
	return companyDao;
}

@Resource
private LabelDao labelDao;

public void setLabelDao(LabelDao labelDao) {
	this.labelDao = labelDao;
}

@Override
public DAO<Company> getDao() {
	return companyDao;
}

public void setCompanyDao(CompanyDao companyDao) {
	this.companyDao = companyDao;
}

@Transactional(readOnly = true)
public List<Company> findByLabel(Label label, int start, int length) {
	Label lab = labelDao.findById(label.getId());
	return new ArrayList<Company>(lab.getCompanies());
}

public List<Company> findByLabel(Label label) {
	return findByLabel(label, 0, 0);
}

@Transactional
public boolean addLabelToCompany(Long companyId, Label label) {
	Company company = companyDao.findById(companyId);

	boolean contain = false;
	for (Label lab : company.getLabels()) {
		if (lab.getLabelName().equals(label.getLabelName())) {
			contain = true;
			break;
		}
	}

	if (!contain) {
		company.getLabels().add(label);
		return true;
	}
	return false;
}


@Transactional
public List<Company> search(String company, int startIndex, int maxResult){
	return companyDao.searchByCompanyName(company, startIndex, maxResult);
}
}
