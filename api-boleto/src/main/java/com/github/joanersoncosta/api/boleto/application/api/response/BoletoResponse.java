package com.github.joanersoncosta.api.boleto.application.api.response;

import java.util.UUID;

import com.github.joanersoncosta.api.boleto.domain.Boleto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class BoletoResponse {
	private final UUID idBoleto;
	
	public BoletoResponse(Boleto boleto) {
		this.idBoleto = boleto.getIdBoleto();
	}

}
