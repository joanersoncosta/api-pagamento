package com.github.joanersoncosta.api.credencial.application.repository;

import com.github.joanersoncosta.api.credencial.domain.Credencial;

public interface CredencialRepository {
	Credencial salva(Credencial credencial);
	Credencial buscaCredencialPorUsuario(String usuario);
}
