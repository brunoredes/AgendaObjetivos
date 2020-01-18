package br.com.bandtec.zoomzinho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.zoomzinho.dao.TodosLivros;
import br.com.bandtec.zoomzinho.model.Livro;

@RestController
public class LivrosController {

	private TodosLivros todosLivros;

	@Autowired
	public LivrosController(TodosLivros todosLivros) {
		this.todosLivros = todosLivros;
	}

	@GetMapping("/livros/tema/{tema}")
	public ResponseEntity<List<Livro>> buscaTema(@PathVariable("tema") String tema) {
		List<Livro> livros = todosLivros.buscaTema(tema);
		if (livros.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(livros);
		}

	}
	
	@GetMapping("/livros/nome/{nome}")
	public ResponseEntity<List<Livro>> buscaNome(@PathVariable("nome") String nome) {
		List<Livro> livros = todosLivros.buscaNome(nome);
		if (livros.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(livros);
		}
	
	}
}
