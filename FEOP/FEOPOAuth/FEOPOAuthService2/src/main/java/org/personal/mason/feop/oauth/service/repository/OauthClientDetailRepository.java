package org.personal.mason.feop.oauth.service.repository;

import java.util.List;

import org.personal.mason.feop.oauth.common.data.FEOPJpaRepository;
import org.personal.mason.feop.oauth.service.domain.OauthClientDetail;

public interface OauthClientDetailRepository extends FEOPJpaRepository<OauthClientDetail, Long> {

	List<OauthClientDetail> findByClientId(String clientid);

	List<OauthClientDetail> findByOwner(String owner);
}
