package br.unisul.pweb.diego.trabalho.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unisul.pweb.diego.trabalho.domain.Departamento;
import br.unisul.pweb.diego.trabalho.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository rep;
	@Autowired
	private EmpresaService empresaService;

	public List<Departamento> findByEmpresa(Integer empresaId) {
		return rep.findDepartamentos(empresaId);
	}
	public Departamento insert (Departamento obj) {
		obj.setId(null);
		obj.setEmpresa(empresaService.find(obj.getEmpresa().getId()));
		obj = rep.save(obj);
		return obj;
	}
	//BUSCAR POR ID
	public Departamento find (Integer id) {
		Optional<Departamento> obj = rep.findById(id);
		return obj.orElse(null);
	}

}