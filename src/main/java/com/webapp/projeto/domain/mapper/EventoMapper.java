package com.webapp.projeto.domain.mapper;

import com.webapp.projeto.application.dto.request.EventoRequest;
import com.webapp.projeto.application.dto.response.EventoResponse;
import com.webapp.projeto.domain.model.Evento;
import org.mapstruct.Mapper;

@Mapper
public interface EventoMapper {

    EventoResponse paraEventoResponse(Evento evento);
    Evento paraEvento(EventoRequest eventoRequest);
}
