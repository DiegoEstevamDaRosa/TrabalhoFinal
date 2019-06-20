package br.unisul.pweb.diego.trabalho.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.diego.trabalho.domain.Empresa;
import br.unisul.pweb.diego.trabalho.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empRep;
	
	// BUSCA POR ID
	public Empresa find (Integer id) {
		Optional<Empresa> ob = empRep.findById(id);
		return ob.orElse(null);
	}
	
	// INSERE
	public Empresa insert (Empresa ob) {
		ob.setId(null);
		return empRep.save(ob);
	}
	//DELETAR
		public void delete (Integer id) {
			find(id);
			empRep.deleteById(id);
		}
}
