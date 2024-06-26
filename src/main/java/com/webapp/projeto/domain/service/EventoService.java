package com.webapp.projeto.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.webapp.projeto.application.dto.request.EventoRequest;
import com.webapp.projeto.application.dto.request.StatusDTO;
import com.webapp.projeto.domain.enumeration.StatusEvento;
import com.webapp.projeto.domain.model.Evento;
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

    public EventoResponse recuperarEventoResponse(UUID eventoId) {
        return eventoMapper.paraEventoResponse(this.recuperarEvento(eventoId));
    }

    public EventoResponse criarEvento(EventoRequest eventoRequest){
        final var evento = new Evento();
        evento.setRegistro(LocalDateTime.now());
        evento.setLatitude(eventoRequest.latitude());
        evento.setLongitude(eventoRequest.longitude());
        evento.setDescricao(eventoRequest.descricao());
        evento.setStatus(StatusEvento.valueOf(eventoRequest.status()));

        return eventoMapper.paraEventoResponse(eventoRepository.save(evento));
    }

    public void atualizarEvento(UUID eventoId, StatusDTO status){
        final var evento = this.recuperarEvento(eventoId);
        evento.setStatus(StatusEvento.valueOf(status.status()));
        eventoRepository.save(evento);
    }

    public Evento recuperarEvento(UUID eventoId){
        return eventoRepository
                .findById(eventoId)
                .orElseThrow(
                        () ->
                                new NotFoundException(
                                        String.format("Evento não encontrado para o id %s", eventoId)));
    }

    public List<EventoResponse> recuperarEventos(StatusEvento status){

        return Objects.isNull(status)
                ? eventoMapper.paraEventoResponse(eventoRepository.findAll())
                : eventoMapper.paraEventoResponse(eventoRepository.findAllByStatus(status));
    }

}
