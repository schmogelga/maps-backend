package com.webapp.projeto.application.web;

import com.webapp.projeto.application.dto.request.EventoRequest;
import com.webapp.projeto.application.dto.request.StatusDTO;
import com.webapp.projeto.application.dto.response.EventoResponse;
import com.webapp.projeto.domain.enumeration.StatusEvento;
import com.webapp.projeto.domain.service.EventoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class EventosController implements EventosApi{

    private final EventoService eventoService;

    @Override
    public EventoResponse recuperarEvento(UUID id) {
        return eventoService.recuperarEventoResponse(id);
    }

    @Override
    public List<EventoResponse> recuperarEventos(@RequestParam StatusEvento status) {
        return eventoService.recuperarEventos(status);
    }

    @Override
    public EventoResponse criarEvento(EventoRequest eventoRequest) {
        return eventoService.criarEvento(eventoRequest);
    }

    @Override
    public void atualizarStatus(UUID id, StatusDTO status) {
        eventoService.atualizarEvento(id, status);
    }
}
