package br.com.bandtec.agendadeobjetivos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.agendadeobjetivos.domain.Impeditivo;
import br.com.bandtec.agendadeobjetivos.domain.Objetivo;
import br.com.bandtec.agendadeobjetivos.domain.TodosObjetivos;

@RestController
public class ObjetivosController {

	private final TodosObjetivos todosObjetivos;
	
	@Autowired
	public ObjetivosController(TodosObjetivos todosObjetivos) {
		this.todosObjetivos = todosObjetivos;
	}

	@PostMapping("/objetivos")
	public ResponseEntity<String> cadastrar(@RequestBody Objetivo objetivo) {
		this.todosObjetivos.save(objetivo);
		return ResponseEntity.ok("Sucesso");
	}

	@GetMapping("/objetivos/data/{data}")
	public ResponseEntity<List<Objetivo>> ateAData(@PathVariable("data") String dataString){
		LocalDate data = LocalDate.parse(dataString);
		List<Objetivo> objetivos = todosObjetivos.ate(data);
		if(objetivos.isEmpty()) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(objetivos);
	}
	
	@PostMapping("/objetivos/{id}/impeditivos")
	public ResponseEntity<String> associarImpeditivo(@PathVariable("id") Long objetivoId, @RequestBody Impeditivo impeditivo){
		Objetivo objetivo = this.todosObjetivos.findById(objetivoId).get();
		objetivo.adicionar(impeditivo);//associado impeditivo ao objetivo
		this.todosObjetivos.save(objetivo);//guardar impeditivo: informar jpa: quando guardar objetivo, o objeto das outras tabela tem que guardar em cascata
		return ResponseEntity.ok().build();//insert into objetivo e depois impeditivos
	}
}
