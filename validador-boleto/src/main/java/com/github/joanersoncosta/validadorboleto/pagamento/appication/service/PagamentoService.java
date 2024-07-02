package com.github.joanersoncosta.validadorboleto.pagamento.appication.service;

import com.github.joanersoncosta.validadorboleto.boleto.domain.Boleto;

public interface PagamentoService {
	void pagamento(Boleto boleto);
}
