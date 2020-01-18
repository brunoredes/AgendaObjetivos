package br.com.bandtec.agendadeobjetivos.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosObjetivosTest {
	
	@Autowired
	private TodosObjetivos todosObjetivos;
	
	private Objetivo objetivo;
	
	private Apoiador apoiador;
	
	@Before
	public void setUp() {
		objetivo = new Objetivo(new ResumoDoObjetivo("titulo", "descricao"), 
				LocalDate.now(), new Prioridade("alta", "bem alta"));
		apoiador = new Apoiador("apoiador da silva", "Boa sorte! Confio em você!");
		objetivo.adicionar(apoiador);
		
		todosObjetivos.save(objetivo);
		todosObjetivos.flush();
	}
	
	@Test
	public void persistirObjetivoComApoiador() {
		Objetivo objetivoPersistido = todosObjetivos.getOne(objetivo.getId());
		
		assertEquals(objetivo, objetivoPersistido);
		assertTrue(objetivo.apoiadoPor(apoiador));
	}
	
	@Test
	public void buscarOObjetivoDeUmApoiador() {
		Objetivo objetivoEncontrado = todosObjetivos.doApoiador(apoiador);
		
		assertEquals(objetivo, objetivoEncontrado);
	}
}
