package com.github.joanersoncosta.api.boleto.application.api;

import org.springframework.web.bind.annotation.RestController;

import com.github.joanersoncosta.api.boleto.application.api.request.BoletoRequest;
import com.github.joanersoncosta.api.boleto.application.api.response.BoletoDetalhadoResponse;
import com.github.joanersoncosta.api.boleto.application.api.response.BoletoResponse;
import com.github.joanersoncosta.api.boleto.application.service.BoletoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class BoletoController implements BoletoAPI {
	private final BoletoService boletoService;
	
	@Override
	public BoletoResponse salva(BoletoRequest boletoRequest) {
		log.debug("[start] BoletoController - salva");
		BoletoResponse boletoResponse = boletoService.salva(boletoRequest);
		log.debug("[finish] BoletoController - salva");
		return boletoResponse;
	}

	@Override
	public BoletoDetalhadoResponse buscaBoletoCodigoBarras(String codigoBarras) {
		log.debug("[start] BoletoController - buscaBoletoCodigoBarras");
		BoletoDetalhadoResponse boletoResponse = boletoService.buscaBoletoCodigoBarras(codigoBarras);
		log.debug("[finish] BoletoController - buscaBoletoCodigoBarras");
		return boletoResponse;
	}

}