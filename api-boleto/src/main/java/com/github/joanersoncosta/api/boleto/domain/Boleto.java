package com.github.joanersoncosta.api.boleto.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.github.joanersoncosta.api.boleto.domain.enuns.SituacaoBoleto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Entity
public class Boleto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID idBoleto;
	private String codigoBarras;
	private SituacaoBoleto situacaoBoleto;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataFinalizacao;
}
