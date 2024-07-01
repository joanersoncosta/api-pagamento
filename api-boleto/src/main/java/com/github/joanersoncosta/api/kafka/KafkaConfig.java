package com.github.joanersoncosta.api.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class KafkaConfig {
	@Value("${spring.kafka.topico-boleto}")
	private String topico;
}
