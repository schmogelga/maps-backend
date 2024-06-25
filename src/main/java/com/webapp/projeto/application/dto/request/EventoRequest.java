package com.webapp.projeto.application.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record EventoRequest(
        String descricao, Double latitude, Double longitude, String status) {
}
