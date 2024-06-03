package com.webapp.projeto.domain.service;

import java.util.UUID;

import com.webapp.projeto.application.dto.request.EventoRequest;
import org.springframework.stereotype.Service;

import com.webapp.projeto.application.dto.response.EventoResponse;
import com.webapp.projeto.domain.mapper.EventoMapper;
import com.webapp.projeto.infrastructure.exception.NotFoundException;
import com.webapp.projeto.infrastructure.repository.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;

@Service
@RequiredArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;

    private final EventoMapper eventoMapper = Mappers.getMapper(EventoMapper.class);

    public EventoResponse recuperarEvento(UUID eventoId) {
        return eventoMapper.paraEventoResponse(
                eventoRepository
                        .findById(eventoId)
                        .orElseThrow(
                                () ->
                                        new NotFoundException(
                                                String.format("Evento não encontrado para o id %s", eventoId))));
    }

    public EventoResponse criarEvento(EventoRequest eventoRequest){
        final var evento = eventoMapper.paraEvento(eventoRequest);

        return eventoMapper.paraEventoResponse(eventoRepository.save(evento));
    }


}
