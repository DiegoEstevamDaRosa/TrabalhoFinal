package br.unisul.pweb.diego.trabalho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.pweb.diego.trabalho.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{

//	@Transactional(readOnly=true)
//	public List<Departamento> findAllByOrderByNome();
	
}
