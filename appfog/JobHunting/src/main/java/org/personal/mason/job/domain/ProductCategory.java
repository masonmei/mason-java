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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ProductCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product_category")
public class ProductCategory implements java.io.Serializable {

private static final long serialVersionUID = 2525118754562667881L;

// Fields
private Long id;
private ProductCategory productCategory;
private String categoryName;
private String desc;
private Set<Product> products = new HashSet<Product>(0);
private Set<ProductCategory> productCategories = new HashSet<ProductCategory>(
        0);

// Constructors

/** default constructor */
public ProductCategory() {
}

/** minimal constructor */
public ProductCategory(String categoryName) {
	this.categoryName = categoryName;
}

/** full constructor */
public ProductCategory(ProductCategory productCategory,
        String categoryName, String desc, Set<Product> products,
        Set<ProductCategory> productCategories) {
	this.productCategory = productCategory;
	this.categoryName = categoryName;
	this.desc = desc;
	this.products = products;
	this.productCategories = productCategories;
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

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "parent_id")
public ProductCategory getProductCategory() {
	return this.productCategory;
}

public void setProductCategory(ProductCategory productCategory) {
	this.productCategory = productCategory;
}

@Column(name = "category_name", nullable = false, length = 100)
public String getCategoryName() {
	return this.categoryName;
}

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

@Column(name = "desc", length = 100)
public String getDesc() {
	return this.desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productCategory")
public Set<Product> getProducts() {
	return this.products;
}

public void setProducts(Set<Product> products) {
	this.products = products;
}

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productCategory")
public Set<ProductCategory> getProductCategories() {
	return this.productCategories;
}

public void setProductCategories(Set<ProductCategory> productCategories) {
	this.productCategories = productCategories;
}

}