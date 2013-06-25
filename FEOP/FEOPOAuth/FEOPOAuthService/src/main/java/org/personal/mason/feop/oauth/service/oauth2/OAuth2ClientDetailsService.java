package org.personal.mason.feop.oauth.service.oauth2;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.personal.mason.feop.oauth.service.domain.OauthClientDetail;
import org.personal.mason.feop.oauth.service.spi.OClientDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.BaseClientDetails;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

public class OAuth2ClientDetailsServiceImpl implements ClientDetailsService {
	
	private OClientDetailService clientDetailService;
	
	@Autowired
	public void setClientDetailService(OClientDetailService clientDetailService) {
		this.clientDetailService = clientDetailService;
	}

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		OauthClientDetail client = clientDetailService.findByClientId(clientId);
		// 客户端为空，则提示OAuth2 ERROR
		if (null == client) {
			throw new ClientRegistrationException("invalid_client");
		}
		BaseClientDetails clientDetails = new BaseClientDetails();
		// 客户端ID
		clientDetails.setClientId(clientId);
		// 客户端密钥secret
		clientDetails.setClientSecret(StringUtils.trim(client.getClientSecret()));
		// 获得客户端scope
		String scope = StringUtils.trim(client.getScope());
		Set<String> scopeSet = this.getClientConfigInfo(scope);
		clientDetails.setScope(scopeSet);
		// 获得客户端redirect_uri
		String registeredRedirectUris = StringUtils.trim(client.getWebServerRedirectUri());
		Set<String> uriSet = this.getClientConfigInfo(registeredRedirectUris);
		clientDetails.setRegisteredRedirectUri(uriSet);
		// 客户端角色
		String authoritieStr = StringUtils.trim(client.getAuthorities());
		Set<String> authoritySet = this.getClientConfigInfo(authoritieStr);
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		for (String item : authoritySet) {
			authorities.add(new SimpleGrantedAuthority(item));
		}

		clientDetails.setAuthorities(authorities);

		// 获得客户端Grant type
		String grantTypes = StringUtils.trim(client.getAuthorizedGrantTypes());

		Set<String> grantTypeSet = this.getClientConfigInfo(grantTypes);

		clientDetails.setAuthorizedGrantTypes(grantTypeSet);

		// 访问令牌过期时间
		clientDetails.setAccessTokenValiditySeconds(client.getAccessTokenValidity());

		// 刷新令牌过期时间
		clientDetails.setRefreshTokenValiditySeconds(client.getRefreshTokenValidity());

		// 获得客户端redirect_uri
		String resourceIds = StringUtils.trim(client.getResourceIds());

		Set<String> resourceIdSet = this.getClientConfigInfo(resourceIds);

		clientDetails.setResourceIds(resourceIdSet);

		return clientDetails;
	}

	/**
	 * 集中处理客户端数据表各项中含有(,)逗号
	 * 
	 * @param config
	 * @return
	 */
	private Set<String> getClientConfigInfo(String config) {

		if (StringUtils.isBlank(config)) {
			return null;
		}

		String[] configArr = config.split(",");

		Set<String> configSet = new HashSet<String>();

		for (String item : configArr) {
			configSet.add(item);
		}

		return configSet;
	}

}
