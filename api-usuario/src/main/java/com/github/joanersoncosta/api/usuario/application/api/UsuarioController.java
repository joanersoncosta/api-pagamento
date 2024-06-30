package com.github.joanersoncosta.api.usuario.application.api;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.github.joanersoncosta.api.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.api.usuario.application.api.response.UsuarioCriadoResponse;
import com.github.joanersoncosta.api.usuario.application.api.response.UsuarioDetalhadoResponse;
import com.github.joanersoncosta.api.usuario.application.service.UsuarioService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Validated
@Log4j2
@RequiredArgsConstructor
public class UsuarioController implements UsuarioAPI {
	private final UsuarioService usuarioAppplicationService;

	@Override
	public UsuarioCriadoResponse postNovoUsuario(UsuarioNovoRequest usuarioNovo) {
		log.debug("[start] UsuarioController - postNovoUsuario");
		UsuarioCriadoResponse usuarioCriado = usuarioAppplicationService.criaNovoUsuario(usuarioNovo);
		log.debug("[start] UsuarioController - postNovoUsuario");
		return usuarioCriado;
	}

	@Override
	public UsuarioDetalhadoResponse buscaUsuarioPorId(UUID idUsuario) {
		log.debug("[start] UsuarioController - buscaUsuarioPorId");
		log.debug("[idUsuario] {}", idUsuario);
		UsuarioDetalhadoResponse usuarioResponse = usuarioAppplicationService.buscaUsuarioPorId(idUsuario);
		log.debug("[finaliza] UsuarioController - buscaUsuarioPorId");
		return usuarioResponse;
	}
	
}
