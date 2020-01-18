package br.com.bandtec.agendadeobjetivos.domain;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Livraria {
	
	private RestTemplate restTemplate;//conector, passando dados de entrada, 
										//funfa como conector p outro sistema
	private String url;
	
	public Livraria() {
		restTemplate = new RestTemplate();
		url = "http://localhost:8081/livros";
	}
	
	public List<Livro> findWithTheme(String tema){
		String urlBusca = url + "/tema/" + tema;	
		ResponseEntity<List> resposta = restTemplate.getForEntity(urlBusca, List.class);
		return resposta.getBody();
	}
	
	public List<Livro> buscarLivroPorNome(String nome){
		String urlBusca = url + "/nome/" + nome;	
		ResponseEntity<List> resposta = restTemplate.getForEntity(urlBusca, List.class);
		return resposta.getBody();
	}
	
	public String cadastrarOpiniao(Opiniao opiniao) {
		String urlCadastro = url + "/tema/opinar";
		ResponseEntity<String> resposta = restTemplate.postForEntity(urlCadastro, opiniao, String.class);
		return resposta.getBody();
	}
	
	public List<Opiniao> lerTodasOpinioes(){
		String urlBuscaOpinioes = url + "/tema/todasOpinioes";
		ResponseEntity<Opiniao[]> resposta = restTemplate.getForEntity(urlBuscaOpinioes, Opiniao[].class);
		return Arrays.asList(resposta.getBody());
	}
	
	
}
