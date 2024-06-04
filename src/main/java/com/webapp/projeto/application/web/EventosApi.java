package com.webapp.projeto.application.web;

import com.webapp.projeto.application.dto.request.EventoRequest;
import com.webapp.projeto.application.dto.request.RegisterRequestDTO;
import com.webapp.projeto.application.dto.response.EventoResponse;
import com.webapp.projeto.domain.enumeration.StatusEvento;
import com.webapp.projeto.domain.model.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Eventos", description = "Operações de eventos")
@RequestMapping("/eventos")
public interface EventosApi {


    @Operation(summary = "Recupera um evento", description = "Recupera um evento", method = "GET")
    @GetMapping("{id}")
    EventoResponse recuperarEvento(@PathVariable UUID id);

    @Operation(summary = "Cria um evento", description = "Cria um evento", method = "POST")
    @PostMapping()
    EventoResponse criarEvento(@RequestBody EventoRequest eventoRequest);

    @Operation(summary = "Atualiza um evento", description = "Atualiza um evento", method = "POST")
    @PatchMapping("/{id}")
    void atualizarStatus(@PathVariable UUID id,  @RequestParam StatusEvento status);

}
