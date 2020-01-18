package br.com.bandtec.agendadeobjetivos.domain;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LivrariaTest2 {
	
	private Livraria livraria;
	
	@Before
	public void setUp() {
		livraria = new Livraria();
	}
	
	
	@Test
	public void listarLivrosPorNome() {
		List<Livro> livros = livraria.buscarLivroPorNome("java");
		if(livros == null || livros.isEmpty()) {
			Assert.fail("Não tem nenhum livro cadastrado ainda. Ou a conexão com o microserviço não está funcionando");
		}
		else {
			for(Livro livro : livros) {
				assertNotNull(livro.getTema());
				assertNotNull(livro.getTitulo());
			}
		}
	}
}
