package com.github.joanersoncosta.api.autentica.application.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.github.joanersoncosta.api.autentica.domain.Token;

public interface AutenticacaoApplicationService {
    Token autentica(UsernamePasswordAuthenticationToken userCredentials);
    Token reativaToken(String tokenExpirado);
}
