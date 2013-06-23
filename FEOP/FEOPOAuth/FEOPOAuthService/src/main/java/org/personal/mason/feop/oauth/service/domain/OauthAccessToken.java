package org.personal.mason.feop.oauth.service.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the oauth_access_token database table.
 * 
 */
@Entity
@Table(name = "oauth_access_token")
public class OauthAccessToken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Lob
	private byte[] authentication;

	@Column(name = "authentication_id", unique = true)
	private String authenticationId;

	@Column(name = "client_id")
	private String clientId;

	@Column(name = "refresh_token")
	private String refreshToken;

	@Lob
	private byte[] token;

	@Column(name = "token_id", unique = true)
	private String tokenId;

	@Column(name = "user_name")
	private String userName;

	public OauthAccessToken() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getAuthentication() {
		return this.authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}

	public String getAuthenticationId() {
		return this.authenticationId;
	}

	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRefreshToken() {
		return this.refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public byte[] getToken() {
		return this.token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}

	public String getTokenId() {
		return this.tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}