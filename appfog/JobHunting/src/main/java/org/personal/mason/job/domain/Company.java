package org.personal.mason.job.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "company")
public class Company implements java.io.Serializable {
private static final long serialVersionUID = -9031667342473361183L;
// Fields

private Long id;
private String companyName;
private String provice;
private String city;
private String businessType;
private Integer scale;
private String desc;
private Set<CompanyLabel> companyLabels = new HashSet<CompanyLabel>(0);
private Set<News> newses = new HashSet<News>(0);
private Set<Product> products = new HashSet<Product>(0);
private Set<Job> jobs = new HashSet<Job>(0);

// Constructors

/** default constructor */
public Company() {
}

/** minimal constructor */
public Company(String companyName, String provice) {
	this.companyName = companyName;
	this.provice = provice;
}

/** full constructor */
public Company(String companyName, String provice, String city,
        String businessType, Integer scale, String desc,
        Set<CompanyLabel> companyLabels, Set<News> newses,
        Set<Product> products, Set<Job> jobs) {
	this.companyName = companyName;
	this.provice = provice;
	this.city = city;
	this.businessType = businessType;
	this.scale = scale;
	this.desc = desc;
	this.companyLabels = companyLabels;
	this.newses = newses;
	this.products = products;
	this.jobs = jobs;
}

// Property accessors
@Id
@GeneratedValue(strategy = IDENTITY)
@Column(name = "id", unique = true, nullable = false)
public Long getId() {
	return this.id;
}

public void setId(Long id) {
	this.id = id;
}

@Column(name = "company_name", nullable = false, length = 100)
public String getCompanyName() {
	return this.companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

@Column(name = "provice", nullable = false, length = 20)
public String getProvice() {
	return this.provice;
}

public void setProvice(String provice) {
	this.provice = provice;
}

@Column(name = "city", length = 20)
public String getCity() {
	return this.city;
}

public void setCity(String city) {
	this.city = city;
}

@Column(name = "business_type", length = 50)
public String getBusinessType() {
	return this.businessType;
}

public void setBusinessType(String businessType) {
	this.businessType = businessType;
}

@Column(name = "scale")
public Integer getScale() {
	return this.scale;
}

public void setScale(Integer scale) {
	this.scale = scale;
}

@Column(name = "desc", length = 65535)
public String getDesc() {
	return this.desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
public Set<CompanyLabel> getCompanyLabels() {
	return this.companyLabels;
}

public void setCompanyLabels(Set<CompanyLabel> companyLabels) {
	this.companyLabels = companyLabels;
}

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
public Set<News> getNewses() {
	return this.newses;
}

public void setNewses(Set<News> newses) {
	this.newses = newses;
}

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
public Set<Product> getProducts() {
	return this.products;
}

public void setProducts(Set<Product> products) {
	this.products = products;
}

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
public Set<Job> getJobs() {
	return this.jobs;
}

public void setJobs(Set<Job> jobs) {
	this.jobs = jobs;
}

}