package com.github.joanersoncosta.api.boleto.application.api.request;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public record BoletoRequest(
		@NotBlank(message = "não pode ser nullo ou em branco!") 
		UUID idUsuario,	
		@NotBlank(message = "não pode ser nullo ou em branco!") 
		String codigoBarras) {
}
