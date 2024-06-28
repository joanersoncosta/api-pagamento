package com.github.joanersoncosta.api.usuario.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;

import com.github.joanersoncosta.api.handler.APIException;

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

    public void validaUsuario(UUID idUsuario) {
        if (!this.idUsuario.equals(idUsuario)) {
            throw APIException.build(HttpStatus.UNAUTHORIZED, "Credencial de autenticação não é válida.");
        }
    }
}
