package com.github.joanersoncosta.api.kafka.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.github.joanersoncosta.avro.BoletoAvro;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RequiredArgsConstructor
@Log4j2
public class BoletoProducer {
	
	@Value("${spring.kafka.topico-boleto}")
	private String topico;	
	private final KafkaTemplate<String, BoletoAvro> kafkaTemplate;

	public void enviarMensagem(BoletoAvro boletoAvro) {
		log.debug("[start] BoletoProducer - enviarMensagem");
		log.debug("[boletoAvro] enviando boleto: {}", boletoAvro);
		kafkaTemplate.send(topico, null, boletoAvro);
		log.debug("[finish] BoletoProducer - enviarMensagem");
	}

}