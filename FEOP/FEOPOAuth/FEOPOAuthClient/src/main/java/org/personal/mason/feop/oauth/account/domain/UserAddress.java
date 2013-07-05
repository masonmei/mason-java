package org.personal.mason.feop.oauth.account.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "user_address")
public class UserAddress extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "id", insertable=false, updatable=false)
	private AccountUser accountUser;
	@Column(name = "line_one", nullable = false)
	private String lineOne;
	@Column(name = "line_two")
	private String lineTwo;
	@Column(name = "line_three")
	private String lineThree;
	@Column(name = "postcode")
	private String postcode;
	@Column(name = "primary")
	private Boolean primary = false;

	public AccountUser getAccountUser() {
		return accountUser;
	}

	public void setAccountUser(AccountUser accountUser) {
		this.accountUser = accountUser;
	}

	public String getLineOne() {
		return lineOne;
	}

	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}

	public String getLineTwo() {
		return lineTwo;
	}

	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}

	public String getLineThree() {
		return lineThree;
	}

	public void setLineThree(String lineThree) {
		this.lineThree = lineThree;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Boolean getPrimary() {
		return primary;
	}

	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

}
