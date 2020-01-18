package br.com.bandtec.agendadeobjetivos.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Livro {
	@JsonProperty
	private String tema;
	@JsonProperty
	private String titulo;

	public Livro() {
	}

	public Livro(String tema, String titulo) {
		this.tema = tema;
		this.titulo = titulo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
