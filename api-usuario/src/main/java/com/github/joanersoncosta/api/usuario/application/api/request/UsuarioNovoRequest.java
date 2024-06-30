package com.github.joanersoncosta.api.usuario.application.api.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public record UsuarioNovoRequest(
	@Email
	@NotBlank
	String email,
	@CPF
	@NotBlank
	String cpf,
	@Size(min = 6)
	@NotBlank
	String senha){
}