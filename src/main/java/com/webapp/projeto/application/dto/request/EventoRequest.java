package com.webapp.projeto.application.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record EventoRequest(
        String descricao, Long latitude, Long longitude, LocalDateTime registro, String status) {
}
