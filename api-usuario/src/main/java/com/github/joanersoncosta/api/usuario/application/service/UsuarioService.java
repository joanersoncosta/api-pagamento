package com.github.joanersoncosta.api.usuario.application.service;

import com.github.joanersoncosta.api.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.api.usuario.application.api.response.UsuarioCriadoResponse;

public interface UsuarioService {
	UsuarioCriadoResponse criaNovoUsuario(UsuarioNovoRequest usuarioNovo);
}
