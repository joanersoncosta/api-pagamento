package com.github.joanersoncosta.api.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.github.joanersoncosta.api.boleto.application.service.BoletoService;
import com.github.joanersoncosta.api.boleto.domain.Boleto;
import com.github.joanersoncosta.avro.BoletoAvro;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class NotificacaoConsumer {
	private final BoletoService boletoService;

	@KafkaListener(topics = "${spring.kafka.topico-notificacao}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumer(@Payload BoletoAvro boletoAvro, Acknowledgment ack) throws InterruptedException {
		log.debug("[start] NotificacaoConsumer - consumer");
		log.info("Consumindo mensagem -> {}", boletoAvro);
		Thread.sleep(10000);
		boletoService.atualiza(Boleto.converteParaEntity(boletoAvro));
		ack.acknowledge();
		log.debug("[finish] NotificacaoConsumer - consumer");
	}
}
