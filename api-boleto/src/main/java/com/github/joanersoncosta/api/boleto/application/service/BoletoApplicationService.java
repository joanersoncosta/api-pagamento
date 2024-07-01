package com.github.joanersoncosta.api.boleto.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.api.boleto.application.api.request.BoletoRequest;
import com.github.joanersoncosta.api.boleto.application.api.response.BoletoDetalhadoResponse;
import com.github.joanersoncosta.api.boleto.application.api.response.BoletoResponse;
import com.github.joanersoncosta.api.boleto.application.repository.BoletoRepository;
import com.github.joanersoncosta.api.boleto.domain.Boleto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2(topic = "BoletoApplicationService")
public class BoletoApplicationService implements BoletoService {
	private final BoletoRepository boletoRepository;
	
	@Override
	public BoletoResponse salva(BoletoRequest boletoRequest) {
		log.debug("[start] BoletoApplicationService - salva");
		var boleto = boletoRepository.salva(new Boleto(boletoRequest));
		log.debug("[finish] BoletoApplicationService - salva");
		return new BoletoResponse(boleto);
	}

	@Override
	public BoletoDetalhadoResponse buscaBoletoCodigoBarras(String codigoBarras) {
		log.debug("[start] BoletoApplicationService - buscaBoletoCodigoBarras");
		var boleto = boletoRepository.buscaBoletoCodigoBarras(codigoBarras);
		log.debug("[finish] BoletoApplicationService - buscaBoletoCodigoBarras");
		return new BoletoDetalhadoResponse(boleto);
	}

}