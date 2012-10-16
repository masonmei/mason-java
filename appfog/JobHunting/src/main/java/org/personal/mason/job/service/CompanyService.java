package org.personal.mason.job.service;

import org.personal.mason.job.dao.CompanyDao;
import org.personal.mason.job.domain.Company;
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
	
}
