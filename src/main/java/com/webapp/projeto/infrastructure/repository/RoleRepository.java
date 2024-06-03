package com.webapp.projeto.infrastructure.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.projeto.domain.model.UserRole;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, UUID> {

    Optional<UserRole> findUserRoleByName(String name);
}
