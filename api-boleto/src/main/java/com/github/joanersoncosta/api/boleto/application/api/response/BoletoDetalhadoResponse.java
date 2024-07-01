package com.github.joanersoncosta.api.boleto.application.api.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.github.joanersoncosta.api.boleto.domain.Boleto;
import com.github.joanersoncosta.api.boleto.domain.enuns.SituacaoBoleto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BoletoDetalhadoResponse {
	
	private UUID idBoleto;
	private String codigoBarras;
	private SituacaoBoleto situacao;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataFinalizacao;
	
	public BoletoDetalhadoResponse(Boleto boleto) {
		this.idBoleto = idBoleto;
		this.codigoBarras = codigoBarras;
		this.situacao = situacao;
		this.dataCriacao = dataCriacao;
		this.dataFinalizacao = dataFinalizacao;
	}
	
}
