package com.github.joanersoncosta.validadorboleto.boleto.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.github.joanersoncosta.avro.BoletoAvro;
import com.github.joanersoncosta.validadorboleto.boleto.application.repository.BoletoRepository;
import com.github.joanersoncosta.validadorboleto.boleto.domain.enuns.SituacaoBoleto;
import com.github.joanersoncosta.validadorboleto.notificacao.NotificacaoProducer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Entity
public class Boleto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID idBoleto;
	@Column(columnDefinition = "uuid", updatable = false)
	@NotNull
	private UUID idUsuario;
	@NotBlank
	private String codigoBarras;
	@Enumerated(EnumType.STRING)
	private SituacaoBoleto situacaoBoleto;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataFinalizacao;
	
	public Boleto(BoletoAvro boletoAvro) {
		this.codigoBarras = boletoAvro.getCodigoBarras().toString();
		this.situacaoBoleto = SituacaoBoleto.values()[boletoAvro.getSituacaoBoleto()];
	}

	public BoletoAvro converteAvro() {
		return BoletoAvro.newBuilder().setCodigoBarras(this.codigoBarras)
				.setSituacaoBoleto(this.situacaoBoleto.ordinal()).build();
	}
	
	public static Boleto converteParaEntity(BoletoAvro boleto) {
		return new Boleto(boleto);
	}

	public void complementaBoletoValidado(BoletoRepository boletoRepository, NotificacaoProducer notificacaoProducer) {
		var codigo = Integer.parseInt(this.codigoBarras.substring(0, 1));
		if(codigo % 2 == 0) {
			complementaBoletoErroValidacao();
		}else {
			complementaValidado();
		}
		boletoRepository.salva(this);
		notificacaoProducer.enviarMensagem(converteAvro());
	}

	private void complementaBoletoErroValidacao() {
		this.situacaoBoleto = SituacaoBoleto.ERRO_VALIDACAO;
		this.dataFinalizacao = LocalDateTime.now();
	}

	private void complementaValidado() {
		this.situacaoBoleto = SituacaoBoleto.VALIDADO;
		this.dataFinalizacao = LocalDateTime.now();
	}
}