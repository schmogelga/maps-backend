package com.webapp.projeto.infrastructure.repository;

import java.util.List;
import java.util.UUID;

import com.webapp.projeto.domain.enumeration.StatusEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.projeto.domain.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, UUID> {

    List<Evento> findAllByStatus(StatusEvento statusEvento);

}
