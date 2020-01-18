package br.com.bandtec.agendadeobjetivos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class Apoiador {

	@Id
	@GeneratedValue
	private Long id;

	@JsonProperty
	private String nome;

	@JsonProperty
	private String mensagem;

	@ManyToOne
	@JoinColumn(name = "objetivoA_id")
	private Objetivo objetivoA;

	public Apoiador() {
	}

	public Apoiador(String nome, String mensagem) {
		this.nome = nome;
		this.mensagem = mensagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Objetivo getObjetivo() {
		return objetivoA;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivoA = objetivo;
	}

}
