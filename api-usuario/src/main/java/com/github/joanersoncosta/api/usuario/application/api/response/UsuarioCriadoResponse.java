package com.github.joanersoncosta.api.usuario.application.api.response;

import java.util.UUID;

import com.github.joanersoncosta.api.usuario.domain.Usuario;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UsuarioCriadoResponse {
	private final UUID idUsuario;

	public UsuarioCriadoResponse(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
	}
}
