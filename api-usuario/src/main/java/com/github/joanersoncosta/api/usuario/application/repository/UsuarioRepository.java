package com.github.joanersoncosta.api.usuario.application.repository;

import java.util.UUID;

import com.github.joanersoncosta.api.usuario.domain.Usuario;

public interface UsuarioRepository {
	Usuario salva(Usuario usuario);
	Usuario buscaUsuarioPorId(UUID idUsuario);
}
