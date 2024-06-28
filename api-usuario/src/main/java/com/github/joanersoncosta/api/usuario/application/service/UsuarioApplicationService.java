package com.github.joanersoncosta.api.usuario.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.api.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.api.usuario.application.api.response.UsuarioCriadoResponse;
import com.github.joanersoncosta.api.usuario.application.api.response.UsuarioDetalhadoResponse;
import com.github.joanersoncosta.api.usuario.application.repository.UsuarioRepository;
import com.github.joanersoncosta.api.usuario.domain.Usuario;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
	private final UsuarioRepository usuarioRepository;

	@Override
	public UsuarioCriadoResponse criaNovoUsuario(UsuarioNovoRequest usuarioNovo) {
		log.info("[init] UsuarioApplicationService - criaNovoUsuario");
		var usuario = usuarioRepository.salva(new Usuario(usuarioNovo));
		log.info("[finish] UsuarioApplicationService - criaNovoUsuario");
		return new UsuarioCriadoResponse(usuario);
	}

	@Override
	public UsuarioDetalhadoResponse buscaUsuarioPorId(UUID idUsuario) {
		log.info("[init] UsuarioApplicationService - buscaUsuarioPorId");
		var usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
		log.info("[finish] UsuarioApplicationService - buscaUsuarioPorId");
		return new UsuarioDetalhadoResponse(usuario);
	}
}
