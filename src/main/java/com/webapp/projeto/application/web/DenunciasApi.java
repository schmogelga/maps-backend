package com.webapp.projeto.application.web;

import com.webapp.projeto.application.dto.request.DenunciaRequest;
import com.webapp.projeto.application.dto.request.EventoRequest;
import com.webapp.projeto.application.dto.response.EventoResponse;
import com.webapp.projeto.domain.enumeration.StatusEvento;
import com.webapp.projeto.domain.model.Denuncia;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Denuncias", description = "Operações de denuncias")
@RequestMapping()
public interface DenunciasApi {

    @Operation(summary = "Cria uma denuncia", description = "Cria uma denuncia", method = "POST")
    @PostMapping("eventos/{eventoId}/denucias")
    Denuncia criarDenuncia(@PathVariable UUID eventoId, @RequestBody DenunciaRequest denunciaRequest);

}
