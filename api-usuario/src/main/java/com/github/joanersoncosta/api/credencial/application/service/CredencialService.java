package com.github.joanersoncosta.api.credencial.application.service;

import com.github.joanersoncosta.api.credencial.domain.Credencial;

public interface CredencialService {
	void criaNovaCredencial(Credencial cliente);
	Credencial buscaCredencialPorUsuario(String usuario);
}
