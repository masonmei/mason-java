package org.personal.mason.feop.oauth.common.data;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FEOPJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

}
