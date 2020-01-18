package br.com.bandtec.zoomzinho.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.bandtec.zoomzinho.model.Livro;

@Repository
public class TodosLivros {

	public List<Livro> buscaTema(String tema) {
		List<Livro> livrosEncontrados = new ArrayList<Livro>();
		for (Livro livro : livros()) {
			if (livro.getTema().equals(tema)) {
				livrosEncontrados.add(livro);
			}
		}
		return livrosEncontrados;
	}
	
	public List<Livro> buscaNome(String nome) {
		List<Livro> livrosEncontrados = new ArrayList<Livro>();
		for (Livro livro : livros()) {
			if (livro.getTitulo().equals(nome)) {
				livrosEncontrados.add(livro);
			}
		}
		return livrosEncontrados;
	}

	private List<Livro> livros() {
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(new Livro("program", "Angular"));
		livros.add(new Livro("esporte", "Tenis"));
		livros.add(new Livro("program", "java"));
		return livros;
	}
}
