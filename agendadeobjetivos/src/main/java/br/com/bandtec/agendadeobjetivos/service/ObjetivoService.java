package br.com.bandtec.agendadeobjetivos.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.bandtec.agendadeobjetivos.domain.Objetivo;
import br.com.bandtec.agendadeobjetivos.domain.TodosObjetivos;
import br.com.bandtec.agendadeobjetivos.domain.TodosUsuarios;
import br.com.bandtec.agendadeobjetivos.domain.Usuario;

public class ObjetivoService {
	
	private final TodosObjetivos todosObjetivos;
	private final TodosUsuarios todosUsuarios;
	
	@Autowired
	public ObjetivoService(TodosObjetivos todosObjetivos, 
			TodosUsuarios todosUsuarios) {
		this.todosObjetivos = todosObjetivos;
		this.todosUsuarios = todosUsuarios;
	}


	public void salvarObjetivo(Long usuarioId, Objetivo objetivo) {
		Usuario usuario = this.todosUsuarios.getOne(usuarioId);
		objetivo.associarA(usuario);
		todosObjetivos.save(objetivo);
	}
	
	
}
