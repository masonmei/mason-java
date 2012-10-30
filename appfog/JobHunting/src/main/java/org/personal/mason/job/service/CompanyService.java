package org.personal.mason.job.service;

import java.util.List;

import javax.annotation.Resource;

import org.personal.mason.job.dao.CompanyDao;
import org.personal.mason.job.dao.DAO;
import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.CompanyLabel;
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

@Override
public DAO<Company> getDao() {
	return companyDao;
}

public void setCompanyDao(CompanyDao companyDao) {
	this.companyDao = companyDao;
}

@Transactional(readOnly = true)
public List<Company> findByLabel(Label label, int start, int length) {
	return companyDao.findByLabel(label, start, length);
}

public List<Company> findByLabel(Label label) {
	return findByLabel(label, 0, 0);
}

@Transactional
public boolean addLabelToCompany(Long companyId, Label label) {
	Company company = companyDao.findById(companyId);
	boolean contain = false;
	for (CompanyLabel companyLabel : company.getCompanyLabels()) {
		if(companyLabel.getLabel().getLabelName().equals(label.getLabelName())){
			contain = true;
			break;
		}
	}
	
	if(!contain){
		CompanyLabel companyLabel = new CompanyLabel();
		companyLabel.setCompany(company);
		companyLabel.setLabel(label);
		company.getCompanyLabels().add(companyLabel );
		companyDao.udpate(company);
		return true;
	}
	return false;
}

}
