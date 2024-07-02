package com.github.joanersoncosta.validadorboleto.boleto.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.validadorboleto.boleto.application.repository.BoletoRepository;
import com.github.joanersoncosta.validadorboleto.boleto.domain.Boleto;
import com.github.joanersoncosta.validadorboleto.notificacao.NotificacaoProducer;
import com.github.joanersoncosta.validadorboleto.pagamento.appication.service.PagamentoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoletoApplicationService implements BoletoService {
	private final BoletoRepository boletoRepository;
	private final NotificacaoProducer notificacaoProducer;
	private final PagamentoService pagamentoService;

	@Override
	public void valida(Boleto boleto) {
		log.debug("[start] BoletoApplicationService - valida");
		boleto.complementaBoletoValidado(boletoRepository, notificacaoProducer, pagamentoService);
		log.debug("[finish] BoletoApplicationService - valida");
	}
}