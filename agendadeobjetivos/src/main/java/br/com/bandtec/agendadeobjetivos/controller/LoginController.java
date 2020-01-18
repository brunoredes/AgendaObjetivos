package br.com.bandtec.agendadeobjetivos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.agendadeobjetivos.domain.TodosUsuarios;
import br.com.bandtec.agendadeobjetivos.seguranca.Credenciais;

@RestController
public class LoginController {

	private final TodosUsuarios todosUsuarios;
	
	@Autowired
	public LoginController(TodosUsuarios todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> efetuarLogin(@RequestBody Credenciais credenciais) {
		ResponseEntity<String> resposta = ResponseEntity.ok("Sucesso");
		if(todosUsuarios.existe(credenciais) == null) {
			resposta = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login/senha não conferem");
		}
		return resposta;
	}

}
