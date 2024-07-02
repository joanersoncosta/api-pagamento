package com.github.joanersoncosta.validadorboleto.boleto.infra;

import org.springframework.stereotype.Repository;

import com.github.joanersoncosta.validadorboleto.boleto.application.repository.BoletoRepository;
import com.github.joanersoncosta.validadorboleto.boleto.domain.Boleto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class BoletoInfraRepository implements BoletoRepository {
	private final BoletoSpringJPARepository boletoSpringJPARepository;

	@Override
	public Boleto salva(Boleto boleto) {
		log.info("[inicia] BoletoInfraRepository - salva");
		var boletoAtualizado = boletoSpringJPARepository.save(boleto);
		log.info("[finaliza] BoletoInfraRepository - salva");
		return boletoAtualizado;
	}
}
