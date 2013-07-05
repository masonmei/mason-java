package org.personal.mason.feop.oauth.service.repository;

import org.personal.mason.feop.oauth.common.data.FEOPJpaRepository;
import org.personal.mason.feop.oauth.service.domain.OauthRole;

public interface OauthRoleRepository extends FEOPJpaRepository<OauthRole, Long>, OauthRoleRepositoryCustom {

}
