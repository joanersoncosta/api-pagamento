package com.github.joanersoncosta.api.usuario.application.service;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.github.joanersoncosta.api.handler.APIException;
import com.github.joanersoncosta.api.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.api.usuario.application.api.response.UsuarioCriadoResponse;
import com.github.joanersoncosta.api.usuario.application.api.response.UsuarioDetalhadoResponse;
import com.github.joanersoncosta.api.usuario.application.repository.UsuarioRepository;
import com.github.joanersoncosta.api.usuario.domain.Usuario;
import com.github.joanersoncosta.api.usuario.infra.SerproClientFeign;
import com.github.joanersoncosta.api.usuario.infra.client.ConcultaCpfResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
	private final UsuarioRepository usuarioRepository;
	private final SerproClientFeign serproClientFeign;
	private static final String TOKEN = "Bearer 06aef429-a981-3ec5-a1f8-71d38d86481e";

	@Override
	public UsuarioCriadoResponse criaNovoUsuario(UsuarioNovoRequest usuarioNovo) {
		log.debug("[start] UsuarioApplicationService - criaNovoUsuario");
		var usuario = usuarioRepository.salva(new Usuario(usuarioNovo));
		log.debug("[finish] UsuarioApplicationService - criaNovoUsuario");
		return new UsuarioCriadoResponse(usuario);
	}

	@Override
	public UsuarioDetalhadoResponse buscaUsuarioPorId(UUID idUsuario) {
		log.debug("[start] UsuarioApplicationService - buscaUsuarioPorId");
		var usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
		log.debug("[finish] UsuarioApplicationService - buscaUsuarioPorId");
		return new UsuarioDetalhadoResponse(usuario);
	}

	@Override
	public void validaCpfUsuario(String cpfUsuario) {
		log.debug("[start] UsuarioApplicationService - validaCpfUsuario");
		ConcultaCpfResponse concultaCPFResponse = serproClientFeign.consultaCPF(TOKEN, cpfUsuario);
		valida(concultaCPFResponse);
		log.debug("[finish] UsuarioApplicationService - validaCpfUsuario");
		log.debug("[TOKEN] {}", TOKEN);
	}
	
	private void valida(ConcultaCpfResponse concultaCPFResponse) {
		log.debug("[start] UsuarioApplicationService - valida");
		if(concultaCPFResponse.isInvalid()) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "CPF Inválido!");
		}
		log.debug("[finish] UsuarioApplicationService - valida");
	}
}