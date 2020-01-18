package br.com.bandtec.zoomzinho.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.zoomzinho.model.Opiniao;

@RestController
public class OpiniaoController {

	private List<Opiniao> opinioes = new ArrayList<>();
	
	@PostMapping("/livros/tema/opinar")
	public ResponseEntity<String> cadastrar(@RequestBody Opiniao opiniao) {
		opinioes.add(opiniao);
		return ResponseEntity.ok("Opinião cadastrada.");
	}

	@GetMapping("/livros/tema/todasOpinioes")
	public ResponseEntity<List<Opiniao>> exibirTodasOpinioes() {
		return ResponseEntity.ok(opinioes);
	}
}
