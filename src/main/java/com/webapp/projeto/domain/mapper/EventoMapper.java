package com.webapp.projeto.domain.mapper;

import com.webapp.projeto.application.dto.request.EventoRequest;
import com.webapp.projeto.application.dto.response.EventoResponse;
import com.webapp.projeto.domain.model.Evento;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EventoMapper {

    EventoResponse paraEventoResponse(Evento evento);

    List<EventoResponse> paraEventoResponse(List<Evento> eventos);


    Evento paraEvento(EventoRequest eventoRequest);
}
