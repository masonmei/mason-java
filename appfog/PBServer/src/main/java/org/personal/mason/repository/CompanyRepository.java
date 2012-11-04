package org.personal.mason.repository;

import java.util.List;

import org.personal.mason.domain.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {

List<Company> findByProvince(String province);

List<Company> findByProvinceAndCity(String province, String city);

List<Company> findByCompanyNameLike(String companyName);

List<Company> findByLabelsLabelName(String labelName);
}
