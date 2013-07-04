package org.personal.mason.feop.oauth.common.repository;

import org.personal.mason.feop.oauth.common.domain.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRecordRepository extends JpaRepository<UserRecord,	Long>{

}
