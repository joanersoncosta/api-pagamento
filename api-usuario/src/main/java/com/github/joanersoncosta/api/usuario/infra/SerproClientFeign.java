package com.github.joanersoncosta.api.usuario.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.github.joanersoncosta.api.usuario.infra.client.ConcultaCpfResponse;

@FeignClient(name = "serproClient", url = "https://gateway.apiserpro.serpro.gov.br/consulta-cpf-df-trial")
public interface SerproClientFeign {
	@GetMapping(path = "/v1/cpf/{cpfUsuario}")
	ConcultaCpfResponse consultaCPF(@RequestHeader(value = "Authorization") String token,
			@PathVariable String cpfUsuario);
}