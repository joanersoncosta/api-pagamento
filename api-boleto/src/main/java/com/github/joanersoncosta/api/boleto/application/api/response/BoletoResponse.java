package com.github.joanersoncosta.api.boleto.application.api.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.github.joanersoncosta.api.boleto.domain.Boleto;
import com.github.joanersoncosta.api.boleto.domain.enuns.SituacaoBoleto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class BoletoResponse {
	private final UUID idBoleto;
	private String codigoBarras;
	private SituacaoBoleto situacao;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataFinalizacao;
	
	public BoletoResponse(Boleto boleto) {
		this.idBoleto = boleto.getIdBoleto();
	}

}
