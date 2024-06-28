package com.github.joanersoncosta.api.credencial.infra;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.github.joanersoncosta.api.credencial.application.repository.CredencialRepository;
import com.github.joanersoncosta.api.credencial.domain.Credencial;
import com.github.joanersoncosta.api.handler.APIException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CredencialRepositoryMongoDB implements CredencialRepository {
	private final CredencialMongoSpringRepository credencialMongoRepository;

	@Override
	public Credencial salva(Credencial credencial) {
		log.info("[start] CredencialRepositoryMongoDB - salva");
		credencialMongoRepository.save(credencial);
		log.info("[finish] CredencialRepositoryMongoDB - salva");
		return credencial;
	}

	@Override
	public Credencial buscaCredencialPorUsuario(String usuario) {
		log.info("[start] CredencialRepositoryMongoDB - buscaCredencialPorUsuario");
		var credencial = credencialMongoRepository.findByUsuario(usuario)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Não existe credencial para o cliente informado!"));
		log.info("[start] CredencialRepositoryMongoDB - buscaCredencialPorUsuario");
		return credencial;
	}
}

