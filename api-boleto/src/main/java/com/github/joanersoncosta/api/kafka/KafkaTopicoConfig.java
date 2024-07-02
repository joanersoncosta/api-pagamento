package com.github.joanersoncosta.api.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import lombok.Getter;

@Configuration
@Getter
public class KafkaTopicoConfig {
	@Value("${spring.kafka.topico-boleto}")
	private String topico;
	
	@Bean
	public NewTopic netTopic() {
        return TopicBuilder.name(this.topico).build();
	}
}
