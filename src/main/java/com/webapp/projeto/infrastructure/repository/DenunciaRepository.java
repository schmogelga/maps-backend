package com.webapp.projeto.infrastructure.repository;

import com.webapp.projeto.domain.model.Denuncia;
import com.webapp.projeto.domain.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, UUID> {}
