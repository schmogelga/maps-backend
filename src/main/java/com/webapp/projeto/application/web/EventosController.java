package com.webapp.projeto.application.web;

import com.webapp.projeto.application.dto.request.EventoRequest;
import com.webapp.projeto.application.dto.response.EventoResponse;
import com.webapp.projeto.domain.model.UserInfo;
import com.webapp.projeto.domain.service.EventoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class EventosController implements EventosApi{

    private final EventoService eventoService;

    @Override
    public EventoResponse recuperarEvento(UUID id) {
        return eventoService.recuperarEvento(id);
    }

    @Override
    public EventoResponse criarEvento(EventoRequest eventoRequest) {
        return eventoService.criarEvento(eventoRequest);
    }
}
