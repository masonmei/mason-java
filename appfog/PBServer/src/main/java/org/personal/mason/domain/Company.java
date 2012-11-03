package org.personal.mason.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author mmei
 */

@Document
public class Company {

@Id
private String id;
private String companyName;
private String provice;
private String city;
private String businessType;
private Integer scale;
private String description;

@DBRef
private List<Label> labels;
@DBRef
private List<News> newses;
@DBRef
private List<Product> products;
@DBRef
private List<Job> jobs;

// public Company() {
// }
//
// @PersistenceConstructor
// public Company(String companyName, String province, String city, String
// businessType, Integer scale, String description) {
// this.companyName = companyName;
// this.provice = province;
// this.city = city;
// this.businessType = businessType;
// this.scale = scale;
// this.description = description;
// }

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public String getProvice() {
	return provice;
}

public void setProvice(String provice) {
	this.provice = provice;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getBusinessType() {
	return businessType;
}

public void setBusinessType(String businessType) {
	this.businessType = businessType;
}

public Integer getScale() {
	return scale;
}

public void setScale(Integer scale) {
	this.scale = scale;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public List<Label> getLabels() {
	return labels;
}

public void setLabels(List<Label> labels) {
	this.labels = labels;
}

public List<News> getNewses() {
	return newses;
}

public void setNewses(List<News> newses) {
	this.newses = newses;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}

public List<Job> getJobs() {
	return jobs;
}

public void setJobs(List<Job> jobs) {
	this.jobs = jobs;
}

public String getId() {
	return id;
}

}
