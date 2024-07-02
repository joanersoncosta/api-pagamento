package com.github.joanersoncosta.api.boleto.infra;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.github.joanersoncosta.api.boleto.application.repository.BoletoRepository;
import com.github.joanersoncosta.api.boleto.domain.Boleto;
import com.github.joanersoncosta.api.handler.APIException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class BoletoInfraRepository implements BoletoRepository {
	private final BoletoSpringJPARepository boletoSpringJPARepository;

	@Override
	public Boleto salva(Boleto boleto) {
		log.debug("[start] BoletoInfraRepository - salva");
		var boletoCriado = boletoSpringJPARepository.save(boleto);
		log.debug("[finish] BoletoInfraRepository - salva");
		return boletoCriado;
	}

	@Override
	public Boleto buscaBoletoCodigoBarras(String codigoBarras) {
		log.debug("[start] BoletoInfraRepository - buscaBoletoCodigoBarras");
		Boleto boleto = boletoSpringJPARepository.findByCodigoBarras(codigoBarras)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Boleto não para este código de barras."));
		log.debug("[finish] BoletoInfraRepository - buscaBoletoCodigoBarras");
		return boleto;
	}

	@Override
	public void validaBoletoExistente(String codigoBarras) {
		log.debug("[start] BoletoInfraRepository - validaBoletoExistente");
		boletoSpringJPARepository.findByCodigoBarras(codigoBarras)
        .ifPresent(boletoExistente ->{
            throw APIException.build(HttpStatus.CONFLICT, "Já existe uma solicitação de pagamento para este boleto.");
        });
		log.debug("[finish] BoletoInfraRepository - validaBoletoExistente");
	}

}
