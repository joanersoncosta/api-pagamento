package com.github.joanersoncosta.validadorboleto.boleto.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.validadorboleto.boleto.application.repository.BoletoRepository;
import com.github.joanersoncosta.validadorboleto.boleto.domain.Boleto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoletoApplicationService implements BoletoService {
	private final BoletoRepository boletoRepository;
	
	@Override
	public void valida(Boleto boleto) {
		log.debug("[start] BoletoApplicationService - valida");
		boleto.complementaBoleto(boletoRepository);
		log.debug("[finish] BoletoApplicationService - valida");
	}
}