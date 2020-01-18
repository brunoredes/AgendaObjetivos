package br.com.bandtec.agendadeobjetivos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.agendadeobjetivos.domain.Livraria;
import br.com.bandtec.agendadeobjetivos.domain.Livro;
import br.com.bandtec.agendadeobjetivos.domain.Opiniao;

@RestController
public class LivrosController {

	private Livraria livraria;

	@Autowired
	public LivrosController(Livraria livraria) {
		this.livraria = livraria;
	}
	
	@PostMapping("/livros/opinar")
	public ResponseEntity<String> salvar(@RequestBody Opiniao opiniao){
		String resposta = livraria.cadastrarOpiniao(opiniao);
		return ResponseEntity.ok(resposta);
	}

	@GetMapping("/livros/tema/{tema}")
	public ResponseEntity<List<Livro>> findLivrosComTema(@PathVariable("tema") String tema) {
		List<Livro> livros = livraria.findWithTheme(tema);

		if (livros.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok().body(livros);
		}
	}
	
	@GetMapping("/livros/nome/{nome}")
	public ResponseEntity<List<Livro>> buscarLivroPorNome(@PathVariable("nome") String nome){
		List<Livro> livros = livraria.buscarLivroPorNome(nome);

		if (livros.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok().body(livros);
		}
	}

}
