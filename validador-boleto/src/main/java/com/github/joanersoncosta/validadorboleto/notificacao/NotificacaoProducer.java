package com.github.joanersoncosta.validadorboleto.notificacao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.github.joanersoncosta.avro.BoletoAvro;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class NotificacaoProducer {
	@Value("spring.kafka.topico-notificacao")
	private String topico;
	private final KafkaTemplate<String, BoletoAvro> KafkaTemplate;

	public void enviarMensagem(BoletoAvro boletoAvro) {
		log.debug("[start] NotificacaoProducer - enviarMensagem");
		log.debug("[boletoAvro] enviando boleto: {}", boletoAvro);
		KafkaTemplate.send(topico, null, boletoAvro);
		log.debug("[finish] NotificacaoProducer - enviarMensagem");
	}
}