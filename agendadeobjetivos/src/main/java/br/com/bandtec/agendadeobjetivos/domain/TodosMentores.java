package br.com.bandtec.agendadeobjetivos.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosMentores extends JpaRepository<Mentor, Long>{
	
/*	@Query("select m from Mentor m where m.profissao = :profissao")
	public List<Mentor> porMentor(@Param("profissao")String profissao);*/
}
