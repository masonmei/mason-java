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
@Table(name = "user_record")
public class UserRecord extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id")
	private AccountUser accountUser;

	@Column(name = "type")
	private String type;
	@Column(name = "start_date")
	private Date startdate;
	@Column(name = "end_date")
	private Date enddate;
	@Lob
	@Column(name = "accomplishment")
	private String accomplishment;

	@Column(name = "description")
	private String description;

	public AccountUser getAccountUser() {
		return accountUser;
	}

	public void setAccountUser(AccountUser accountUser) {
		this.accountUser = accountUser;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getAccomplishment() {
		return accomplishment;
	}

	public void setAccomplishment(String accomplishment) {
		this.accomplishment = accomplishment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}