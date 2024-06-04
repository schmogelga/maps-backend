package com.webapp.projeto.domain.service;

import com.webapp.projeto.application.dto.request.DenunciaRequest;
import com.webapp.projeto.application.security.ContextUtil;
import com.webapp.projeto.domain.model.Denuncia;
import com.webapp.projeto.infrastructure.repository.DenunciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DenunciaService {

    private final DenunciaRepository denunciaRepository;
    private final EventoService eventoService;
    private final UserDetailsServiceImpl userDetailsService;

    public Denuncia criarDenuncia(UUID eventoId, DenunciaRequest denunciaRequest){

        final var denuncia = new Denuncia(eventoService.recuperarEvento(eventoId), userDetailsService.recuperarUsuarioLogado(), denunciaRequest.permanece());
        return denunciaRepository.save(denuncia);
    }
}
