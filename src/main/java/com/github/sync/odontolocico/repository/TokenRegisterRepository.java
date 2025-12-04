package com.github.sync.odontolocico.repository;

import com.github.sync.odontolocico.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRegisterRepository extends JpaRepository<TokenEntity,Long> {
    TokenEntity findByValueToken(String valueToken);

    TokenEntity findByClient_EmailClient(String clientEmailClient);
}
