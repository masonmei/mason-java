package org.personal.mason.job.service;

import java.util.List;

import org.personal.mason.job.dao.CompanyDao;
import org.personal.mason.job.domain.Company;
import org.personal.mason.job.domain.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("companyService")
public class CompanyService extends DefaultService<Company> {

	@Autowired
	private CompanyDao companyDao;

	public CompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyDao(CompanyDao companyDao) {
		super.setDao(companyDao);
		this.companyDao = companyDao;
	}
	
	public List<Company> findByLabel(Label label, int start, int length){
		return companyDao.findByLabel(label, start, length);
	} 
	
	public List<Company> findByLabel(Label label){
		return findByLabel(label, 0, 0);
	}
}
