package org.personal.mason.feop.oauth.common.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "user_resource")
public class UserResource extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;
	@Column(name = "resource_name")
	private String resourcename;
	@Column(name = "build_date")
	private Date builddate;
	@Lob
	@Column(name = "desc")
	private String description;
	@ManyToOne
	@JoinColumn(name = "id", insertable=false, updatable=false)
	private AccountUser accountUser;

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public Date getBuilddate() {
		return builddate;
	}

	public void setBuilddate(Date builddate) {
		this.builddate = builddate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AccountUser getAccountUser() {
		return accountUser;
	}

	public void setAccountUser(AccountUser accountUser) {
		this.accountUser = accountUser;
	}

}