package br.unisul.pweb.diego.trabalho.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.pweb.diego.trabalho.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Departamento obj WHERE obj.empresa.id = :empresaId ORDER BY obj.id")
	public List<Departamento> findDepartamentos(@Param("empresaId") Integer empresa_id);
	
	@Query("SELECT departamento FROM Departamento departamento WHERE departamento.nomeDept LIKE %:nome%")
	List<Departamento> findLikeNome(String nome); // BUSCA POR NOME
	
}
