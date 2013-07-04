package org.personal.mason.feop.oauth.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "user_email")
public class UserEmail extends AbstractPersistable<Long> {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id")
	private AccountUser accountUser;

	@Column(name = "label")
	private String label;
	@Column(name = "content")
	private String content;
	@Column(name = "primary")
	private Boolean primary = false;

	public AccountUser getAccountUser() {
		return accountUser;
	}

	public void setAccountUser(AccountUser accountUser) {
		this.accountUser = accountUser;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getPrimary() {
		return primary;
	}

	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

}
