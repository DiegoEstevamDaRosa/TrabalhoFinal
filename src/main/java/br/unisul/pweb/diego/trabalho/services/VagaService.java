package br.unisul.pweb.diego.trabalho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
	
import br.unisul.pweb.diego.trabalho.domain.Vaga;
import br.unisul.pweb.diego.trabalho.repositories.VagaRepository;

@Service
public class VagaService {
		
	@Autowired
	private VagaRepository vagaRep;
	@Autowired
	private EmpresaService empService;
	@Autowired
	private DepartamentoService deptService;

	public List<Vaga> findByEmpresa(Integer empresaId) {
		return vagaRep.findVgtrabalhoEmpresas(empresaId);
	}
	public List<Vaga> findByDepatamento(Integer departamentoId) {
		return vagaRep.findVgtrabalhoDepartametos(departamentoId);
	}
	public Vaga insert (Vaga obj) {
		obj.setId(null);
		obj.setEmpresa(empService.find(obj.getEmpresa().getId()));
		obj.setDepartamento(deptService.find(obj.getDepartamento().getId()));
		obj = vagaRep.save(obj);
		return obj;
	}
		
}	