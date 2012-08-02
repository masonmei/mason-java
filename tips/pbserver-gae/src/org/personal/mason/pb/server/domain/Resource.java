package org.personal.mason.pb.server.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Resources entity. @author MyEclipse Persistence Tools
 */
@Entity
public class Resource implements BaseEntity {

	private static final long serialVersionUID = 7280829499314917780L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String resourcename;
	private Date builddate;
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	private Relation relation;

	// Constructors

	/** default constructor */
	public Resource() {
	}

	/** minimal constructor */
	public Resource(String resourcename) {
		this.resourcename = resourcename;
	}

	/** full constructor */
	public Resource(String resourcename, Date builddate, String description) {
		this.resourcename = resourcename;
		this.builddate = builddate;
		this.description = description;
	}

	// Property accessors
	@Override
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResourcename() {
		return this.resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	@Temporal(TemporalType.DATE)
	public Date getBuilddate() {
		return this.builddate;
	}

	public void setBuilddate(Date builddate) {
		this.builddate = builddate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

}