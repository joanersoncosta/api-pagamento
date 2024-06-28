package com.github.joanersoncosta.api.credencial.infra;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.joanersoncosta.api.credencial.domain.Credencial;

public interface CredencialMongoSpringRepository extends JpaRepository<Credencial, String> {
	Optional<Credencial> findByUsuario(String Usuario);
}
