package com.github.joanersoncosta.api.credencial.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.api.credencial.application.repository.CredencialRepository;
import com.github.joanersoncosta.api.credencial.domain.Credencial;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrendencialApplicationService implements CredencialService {
	private final CredencialRepository credencialRepository;
	
	@Override
	public void criaNovaCredencial(Credencial clienteNovo) {
		log.info("[inicia] CrendencialService - criaNovaCredencial");
		var novaCredencial = new Credencial(clienteNovo.getUsuario(), clienteNovo.getPassword());
		credencialRepository.salva(novaCredencial);
		log.info("[finaliza] CrendencialService - criaNovaCredencial");
	}
	
	@Override
	public Credencial buscaCredencialPorUsuario(String usuario) {
		log.info("[inicia] CredencialSpringDataJpaService - buscaCredencialPorUsuario");
		Credencial credencial = credencialRepository.buscaCredencialPorUsuario(usuario);
		log.info("[finaliza] CredencialSpringDataJpaService - buscaCredencialPorUsuario");
		return credencial;
	}
}
