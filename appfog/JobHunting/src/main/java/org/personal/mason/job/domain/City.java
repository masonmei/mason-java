package org.personal.mason.job.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "city", uniqueConstraints = { @UniqueConstraint(columnNames = "city_name") })
public class City implements Serializable, Comparable<City> {

private static final long serialVersionUID = 4404772094083964627L;
private Long id;
private String cityName;
private Province province;

// Constructors

/** default constructor */
public City() {
}

/** minimal constructor */
public City(String cityName) {
	this.cityName = cityName;
}

public City(String cityName, Province province) {
	this.cityName = cityName;
	this.province = province;
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

@Column(name = "city_name", unique = true, nullable = false, length = 64)
public String getCityName() {
	return this.cityName;
}

public void setCityName(String cityName) {
	this.cityName = cityName;
}

@JsonIgnore
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "province_id", nullable = false)
public Province getProvince() {
	return province;
}

public void setProvince(Province province) {
	this.province = province;
}

@Override
public int compareTo(City o) {
	return this.cityName.compareTo(o.cityName);
}

@Override
public String toString() {
	return "City [id=" + id + ", cityName=" + cityName + ", province=" + province + "]";
}

}
