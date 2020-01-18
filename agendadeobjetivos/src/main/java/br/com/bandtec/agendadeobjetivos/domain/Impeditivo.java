package br.com.bandtec.agendadeobjetivos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="impeditivos")
public class Impeditivo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@JsonProperty
	private String nome;
	
	@JsonProperty
	private String motivo;
	
	@ManyToOne
	@JoinColumn(name = "objetivo_id")
	private Objetivo objetivo;

	public Impeditivo() {}

	public Impeditivo(String nome, String motivo) {
		this.nome = nome;
		this.motivo = motivo;
	}

	void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	public String getNome() {
		return nome;
	}

	public String getMotivo() {
		return motivo;
	}
	
}
