package br.unisul.pweb.diego.trabalho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
	
import br.unisul.pweb.diego.trabalho.domain.Vaga;
import br.unisul.pweb.diego.trabalho.repositories.VagaRepository;

@Service
public class VagaService {
		
	@Autowired
	private VagaRepository rep;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private DepartamentoService departamentoService;

	public List<Vaga> findByEmpresa(Integer empresaId) {
		return rep.findVgtrabalhoEmpresas(empresaId);
	}
	public List<Vaga> findByDepatamento(Integer departamentoId) {
		return rep.findVgtrabalhoDepartametos(departamentoId);
	}
	public Vaga insert (Vaga obj) {
		obj.setId(null);
		obj.setEmpresa(empresaService.find(obj.getEmpresa().getId()));
		obj.setDepartamento(departamentoService.find(obj.getDepartamento().getId()));
		obj = rep.save(obj);
		return obj;
	}
		
}	