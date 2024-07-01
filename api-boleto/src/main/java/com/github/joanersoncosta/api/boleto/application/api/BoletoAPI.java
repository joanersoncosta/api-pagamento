package com.github.joanersoncosta.api.boleto.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.joanersoncosta.api.boleto.application.api.request.BoletoRequest;
import com.github.joanersoncosta.api.boleto.application.api.response.BoletoResponse;

@RestController
@RequestMapping(value = "/v1/boleto")
public interface BoletoAPI {
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	BoletoResponse salva(@RequestBody @Validated BoletoRequest boletoRequest);

}
