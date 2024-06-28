package com.github.joanersoncosta.api.usuario.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.joanersoncosta.api.usuario.domain.Usuario;

public interface UsuarioJpaSpringRepository extends JpaRepository<Usuario, UUID>{

}
