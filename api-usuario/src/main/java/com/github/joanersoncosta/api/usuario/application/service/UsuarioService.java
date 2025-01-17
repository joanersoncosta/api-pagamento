package com.github.joanersoncosta.api.usuario.application.service;

import java.util.UUID;

import com.github.joanersoncosta.api.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.api.usuario.application.api.response.UsuarioCriadoResponse;
import com.github.joanersoncosta.api.usuario.application.api.response.UsuarioDetalhadoResponse;

public interface UsuarioService {
	UsuarioCriadoResponse criaNovoUsuario(UsuarioNovoRequest usuarioNovo);
	UsuarioDetalhadoResponse buscaUsuarioPorId(UUID idUsuario);
	void validaCpfUsuario(String cpfUsuario);
}