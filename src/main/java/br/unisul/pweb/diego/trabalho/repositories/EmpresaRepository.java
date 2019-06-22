package br.unisul.pweb.diego.trabalho.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.pweb.diego.trabalho.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{

	@Transactional(readOnly=true)
	public List<Empresa> findAllByOrderByNome();
	
	@Query("SELECT empresa FROM Empresa empresa WHERE empresa.nome LIKE %:nome%")
	List<Empresa> findLikeNome(String nome);
	
}
