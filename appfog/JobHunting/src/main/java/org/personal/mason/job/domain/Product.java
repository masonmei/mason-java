package org.personal.mason.job.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {

private static final long serialVersionUID = 4155301186810062870L;
// Fields

private Long id;
private Company company;
private ProductCategory productCategory;
private String productName;
private String shortDesc;
private String description;

// Constructors

/** default constructor */
public Product() {
}

/** minimal constructor */
public Product(Long id, Company company, String productName) {
	this.id = id;
	this.company = company;
	this.productName = productName;
}

/** full constructor */
public Product(Long id, Company company, ProductCategory productCategory,
        String productName, String shortDesc, String description) {
	this.id = id;
	this.company = company;
	this.productCategory = productCategory;
	this.productName = productName;
	this.shortDesc = shortDesc;
	this.description = description;
}

// Property accessors
@Id
@Column(name = "id", unique = true, nullable = false)
public Long getId() {
	return this.id;
}

public void setId(Long id) {
	this.id = id;
}

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "company_id", nullable = false)
public Company getCompany() {
	return this.company;
}

public void setCompany(Company company) {
	this.company = company;
}

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "category_id")
public ProductCategory getProductCategory() {
	return this.productCategory;
}

public void setProductCategory(ProductCategory productCategory) {
	this.productCategory = productCategory;
}

@Column(name = "product_name", nullable = false, length = 100)
public String getProductName() {
	return this.productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

@Column(name = "short_desc")
public String getShortDesc() {
	return this.shortDesc;
}

public void setShortDesc(String shortDesc) {
	this.shortDesc = shortDesc;
}

@Column(name = "description", length = 65535)
public String getDescription() {
	return this.description;
}

public void setDescription(String description) {
	this.description = description;
}

}