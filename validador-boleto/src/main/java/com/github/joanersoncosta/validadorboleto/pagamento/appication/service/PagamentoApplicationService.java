package com.github.joanersoncosta.validadorboleto.pagamento.appication.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.validadorboleto.boleto.application.repository.BoletoRepository;
import com.github.joanersoncosta.validadorboleto.boleto.domain.Boleto;
import com.github.joanersoncosta.validadorboleto.notificacao.NotificacaoProducer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2

public class PagamentoApplicationService implements PagamentoService {
	private final BoletoRepository boletoRepository;
	private final NotificacaoProducer notificacaoProducer;

	@Override
	public void pagamento(Boleto boleto) {
		log.debug("[start] PagamentoApplicationService - pagamento");
		boleto.complementaBoletoPagamento(boletoRepository, notificacaoProducer);
		log.debug("[finish] PagamentoApplicationService - pagamento");
	}
}
