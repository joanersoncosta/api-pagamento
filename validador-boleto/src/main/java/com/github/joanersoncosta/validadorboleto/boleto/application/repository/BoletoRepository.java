package com.github.joanersoncosta.validadorboleto.boleto.application.repository;

import com.github.joanersoncosta.validadorboleto.boleto.domain.Boleto;

public interface BoletoRepository {
	Boleto salva(Boleto boleto);
}
