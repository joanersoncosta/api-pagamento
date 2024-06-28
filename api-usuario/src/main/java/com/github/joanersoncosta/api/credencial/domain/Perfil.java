package com.github.joanersoncosta.api.credencial.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Perfil implements GrantedAuthority {
	@Getter
	@Id
	private String nome;

	@Override
	public String getAuthority() {
		return this.nome;
	}

	public Perfil(String perfil) {
		this.nome = perfil;
	}

	private static final long serialVersionUID = 1L;
}
