package br.com.bandtec.agendadeobjetivos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class Mentor {
	@Id
	@GeneratedValue
	private Long id;

	@JsonProperty
	private String nome;

	@JsonProperty
	private String profissao;

	public Mentor(String nome, String profissao) {
		this.nome = nome;
		this.profissao = profissao;
	}

	public Mentor() {
	}

	public String getNome() {
		return nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public Long getId() {
		return id;
	}

}
