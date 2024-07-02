package com.github.joanersoncosta.api.boleto.application.api.request;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BoletoRequest(
		@NotNull(message = "idUsuario não pode ser nullo!") 
		UUID idUsuario,	
		@NotBlank(message = "Código de Barras não pode ser nullo ou em branco!") 
		String codigoBarras) {
}