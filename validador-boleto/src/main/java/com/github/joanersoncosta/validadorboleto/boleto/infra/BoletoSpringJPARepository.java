package com.github.joanersoncosta.validadorboleto.boleto.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.joanersoncosta.validadorboleto.boleto.domain.Boleto;

public interface BoletoSpringJPARepository extends JpaRepository<Boleto, UUID> {
	Optional<Boleto> findByCodigoBarras(String codigoBarras);
}
