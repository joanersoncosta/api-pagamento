package com.github.joanersoncosta.api.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.github.joanersoncosta.api.kafka.KafkaConfig;
import com.github.joanersoncosta.avro.BoletoAvro;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BoletoProducer {
	
	private final KafkaConfig kafkaConfig;
	private final KafkaTemplate<String, BoletoAvro> kafkaTemplate;

	public void enviarMensagem(BoletoAvro boleto) {
		kafkaTemplate.send(kafkaConfig.getTopico(), null, boleto);
	}

}
