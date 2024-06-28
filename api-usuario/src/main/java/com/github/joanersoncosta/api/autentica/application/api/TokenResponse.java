package com.github.joanersoncosta.api.autentica.application.api;

import com.github.joanersoncosta.api.autentica.domain.Token;

import lombok.Value;

@Value
public class TokenResponse {
	private String token;
	private String tipo;

	public TokenResponse(Token token) {
		this.token = token.getToken();
		this.tipo = token.getTipo();
	}
}