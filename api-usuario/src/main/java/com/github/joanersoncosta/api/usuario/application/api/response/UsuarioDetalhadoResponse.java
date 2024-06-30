package com.github.joanersoncosta.api.usuario.application.api.response;

import java.util.UUID;

import com.github.joanersoncosta.api.usuario.domain.Usuario;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UsuarioDetalhadoResponse {
    private UUID idUsuario;
    private String email;
    private String cpf;

	public UsuarioDetalhadoResponse(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.email = usuario.getEmail();
		this.cpf = usuario.getCpf();
	}
}
