package com.github.joanersoncosta.api.usuario.infra;



import org.springframework.stereotype.Repository;

import com.github.joanersoncosta.api.usuario.application.repository.UsuarioRepository;
import com.github.joanersoncosta.api.usuario.domain.Usuario;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class UsuarioRepositoryJpaDB implements UsuarioRepository {
	private final UsuarioJpaSpringRepository usuarioJpaSpringRepository;

	@Override
	public Usuario salva(Usuario usuario) {
		log.info("[init] UsuarioRepositoryJpaDB - salva");
		Usuario novoUsuario = usuarioJpaSpringRepository.save(usuario);
		log.info("[finish] UsuarioRepositoryJpaDB - salva");
		return novoUsuario;
	}
}
