package com.webapp.projeto.application.web;

import com.webapp.projeto.application.dto.request.DenunciaRequest;
import com.webapp.projeto.application.dto.request.EventoRequest;
import com.webapp.projeto.application.dto.response.EventoResponse;
import com.webapp.projeto.domain.enumeration.StatusEvento;
import com.webapp.projeto.domain.model.Denuncia;
import com.webapp.projeto.domain.service.DenunciaService;
import com.webapp.projeto.domain.service.EventoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class DenunciasController implements DenunciasApi{

    private final DenunciaService denunciaService;

    @Override
    public Denuncia criarDenuncia(UUID eventoId, DenunciaRequest denunciaRequest) {
        return denunciaService.criarDenuncia(eventoId, denunciaRequest);
    }
}
