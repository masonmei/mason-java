package org.personal.mason.job.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "province", uniqueConstraints = {
        @UniqueConstraint(columnNames = "province_name") })
public class Province implements Serializable, Comparable<Province> {

private static final long serialVersionUID = 1520454219029832630L;

private Long id;
private String provinceName;

// private Set<City> cities = new HashSet<City>(0);

public Province() {
}

public Province(String provinceName) {
	this.provinceName = provinceName;
	// this.cities = cities;
}

@Id
@GeneratedValue(strategy = IDENTITY)
@Column(name = "id", unique = true, nullable = false)
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

@Column(name = "province_name", unique = true, nullable = false, length = 10)
public String getProvinceName() {
	return provinceName;
}

public void setProvinceName(String provinceName) {
	this.provinceName = provinceName;
}

//
// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "province")
// public Set<City> getCities() {
// return cities;
// }
//
// public void setCities(Set<City> cities) {
// this.cities = cities;
// }

@Override
public int compareTo(Province o) {
	return this.provinceName.compareTo(o.provinceName);
}

@Override
public String toString() {
	return "Province [id=" + id + ", provinceName=" + provinceName + "]";
}

}
