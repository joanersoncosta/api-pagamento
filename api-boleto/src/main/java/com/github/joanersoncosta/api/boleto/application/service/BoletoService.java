package com.github.joanersoncosta.api.boleto.application.service;

import com.github.joanersoncosta.api.boleto.application.api.request.BoletoRequest;
import com.github.joanersoncosta.api.boleto.application.api.response.BoletoDetalhadoResponse;
import com.github.joanersoncosta.api.boleto.application.api.response.BoletoResponse;
import com.github.joanersoncosta.api.boleto.domain.Boleto;

public interface BoletoService {
	BoletoResponse salva(BoletoRequest boletoRequest);
	BoletoDetalhadoResponse buscaBoletoCodigoBarras(String codigoBarras);
	void atualiza(Boleto boleto);
}
