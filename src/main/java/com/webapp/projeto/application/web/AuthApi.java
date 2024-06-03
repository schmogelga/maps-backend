package com.webapp.projeto.application.web;

import org.springframework.web.bind.annotation.*;

import com.webapp.projeto.application.dto.request.RegisterRequestDTO;
import com.webapp.projeto.application.dto.response.JwtResponseDTO;
import com.webapp.projeto.domain.model.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@Tag(name = "Auth", description = "Operações de autenticação")
@RequestMapping()
public interface AuthApi {

    @Operation(
            summary = "Cria um token para um usuário",
            description = "Cria um token para um usuário",
            method = "POST")
    @PostMapping("login")
    JwtResponseDTO login(@RequestHeader("Authorization") String basicAuth);

    @Operation(summary = "Cria um usuário", description = "Cria um usuário", method = "POST")
    @PostMapping("register")
    UserInfo criarUsuario(@RequestBody RegisterRequestDTO registerRequestDTO);

    @Operation(
            summary = "Verifica a validade de um token",
            description = "Verifica a validade de um token",
            method = "POST")
    @GetMapping("validate")
    String validateToken(HttpServletRequest request);
}
