package org.personal.mason.feop.oauth.service.repository;

import org.personal.mason.feop.oauth.service.domain.OauthClientDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.String;
import java.util.List;

public interface OauthClientDetailRepository extends JpaRepository<OauthClientDetail, Long> {

	List<OauthClientDetail> findByClientId(String clientid);

	List<OauthClientDetail> findByOwner(String owner);
}
