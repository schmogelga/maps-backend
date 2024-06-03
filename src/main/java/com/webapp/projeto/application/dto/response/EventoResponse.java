package com.webapp.projeto.application.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record EventoResponse(
        UUID id, String descricao, Long latitude, Long longitude, LocalDateTime registro, String status) {}
