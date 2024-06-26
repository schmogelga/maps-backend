package com.webapp.projeto.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.projeto.domain.model.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    public UserInfo findByUsername(String username);
}
