package com.github.joanersoncosta.api.usuario.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import com.github.joanersoncosta.api.usuario.application.api.request.UsuarioNovoRequest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idUsuario;
    
    @Email
    private String email;
    
    @CPF
    private String cpf;

	public Usuario(UsuarioNovoRequest usuarioNovo) {
		this.email = usuarioNovo.email();
		this.cpf = usuarioNovo.cpf();
	}
}
