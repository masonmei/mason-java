package org.personal.mason.service;

import java.util.List;

import org.personal.mason.domain.Company;
import org.personal.mason.domain.Job;
import org.personal.mason.domain.Label;
import org.personal.mason.domain.News;
import org.personal.mason.domain.Product;
import org.personal.mason.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

@Autowired
private CompanyRepository companyRepository;

public List<Company> findAll() {
	return companyRepository.findAll();
}

public Company findById(String id) {
	return companyRepository.findOne(id);
}

public Company save(Company company) {
	return companyRepository.save(company);
}

public void delete(Company company) {
	companyRepository.delete(company);
}

public void deleteById(String id) {
	companyRepository.delete(id);
}

public Page<Company> findInScope(int page, int size) {
	PageRequest request = new PageRequest(page, size);
	return companyRepository.findAll(request);
}

public List<Company> findByCompanyNameLike(String companyName) {
	return companyRepository.findByCompanyNameLike(companyName);
}

public long count() {
	return companyRepository.count();
}

public boolean addLabelToCompany(String companyId, Label label) {
	Company company = companyRepository.findOne(companyId);

	if (!company.getLabels().contains(label)) {
		company.getLabels().add(label);
		companyRepository.save(company);
		return true;
	}

	return false;
}

public boolean addJobToCompany(String companyId, Job job) {
	Company company = companyRepository.findOne(companyId);

	if (!company.getJobs().contains(job)) {
		company.getJobs().add(job);
		companyRepository.save(company);
		return true;
	}

	return false;
}

public boolean addProductToCompany(String companyId, Product product) {
	Company company = companyRepository.findOne(companyId);

	if (!company.getProducts().contains(product)) {
		company.getProducts().add(product);
		companyRepository.save(company);
		return true;
	}

	return false;
}

public boolean addNewsToCompany(String companyId, News news) {
	Company company = companyRepository.findOne(companyId);

	if (!company.getNewses().contains(news)) {
		company.getNewses().add(news);
		companyRepository.save(company);
		return true;
	}

	return false;
}
}
