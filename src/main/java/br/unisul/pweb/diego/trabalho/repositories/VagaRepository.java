package br.unisul.pweb.diego.trabalho.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.pweb.diego.trabalho.domain.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Integer>{
	
	@Transactional(readOnly=false)
	@Query("SELECT obj FROM Vaga obj WHERE obj.empresa.id = :empresaId ORDER BY obj.id")
	public List<Vaga> findVgtrabalhoEmpresas(@Param("empresaId") Integer empresa_id);
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Vaga obj WHERE obj.departamento.id = :departamentoId ORDER BY obj.id")
	public List<Vaga> findVgtrabalhoDepartametos(@Param("departamentoId") Integer departamento_id);

}
