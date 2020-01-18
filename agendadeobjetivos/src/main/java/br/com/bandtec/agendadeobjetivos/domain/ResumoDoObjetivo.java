package br.com.bandtec.agendadeobjetivos.domain;

import javax.persistence.Embeddable;

@Embeddable
public class ResumoDoObjetivo {
	private String titulo;
	private String descricao;
	
	public ResumoDoObjetivo() {}
	
	public ResumoDoObjetivo(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	
}
