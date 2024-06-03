package com.webapp.projeto.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.projeto.domain.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, UUID> {}
