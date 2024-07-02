package com.github.joanersoncosta.validadorboleto.boleto.application.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.github.joanersoncosta.avro.BoletoAvro;
import com.github.joanersoncosta.validadorboleto.boleto.domain.Boleto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoletoConsumer {
	private final BoletoService boletoService;

	@KafkaListener(topics = "spring.kafka.topico-boleto", groupId = "spring.kafka.consumer.group-id")
	public void consomeBoleto(@Payload BoletoAvro boleto, Acknowledgment ack) throws InterruptedException {
		log.debug("[start] BoletoConsumer - consomeBoleto");
		log.info("Consumindo mensagem: {}", boleto.toString());
		Thread.sleep(10000);
		boletoService.valida(Boleto.converteParaEntity(boleto));
		ack.acknowledge();
		log.debug("[finish] BoletoConsumer - consomeBoleto");
	}
}