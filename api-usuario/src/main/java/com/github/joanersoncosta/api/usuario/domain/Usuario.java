package com.github.joanersoncosta.api.usuario.domain;


import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;

import com.github.joanersoncosta.api.handler.APIException;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Entity(name = "Usuario")
public class Usuario {
	@Id
	private UUID idUsuario;
	@Email
	private String email;
	@CPF
	private String cpf;

	public void validaUsuario(UUID idUsuario) {
		if (!this.idUsuario.equals(idUsuario)) {
			throw APIException.build(HttpStatus.UNAUTHORIZED, "Credencial de autenticação não é válida.");
		}
	}
}