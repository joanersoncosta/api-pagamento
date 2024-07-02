package com.github.joanersoncosta.api.boleto.application.repository;

import com.github.joanersoncosta.api.boleto.domain.Boleto;

public interface BoletoRepository {
	Boleto salva(Boleto boleto);
	Boleto buscaBoletoCodigoBarras(String codigoBarras);
	void validaBoletoExistente(String codigoBarras);
}
