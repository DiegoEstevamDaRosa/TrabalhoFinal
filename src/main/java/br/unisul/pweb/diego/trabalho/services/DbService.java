package br.unisul.pweb.diego.trabalho.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.diego.trabalho.domain.Departamento;
import br.unisul.pweb.diego.trabalho.domain.Empresa;
import br.unisul.pweb.diego.trabalho.repositories.DepartamentoRepository;
import br.unisul.pweb.diego.trabalho.repositories.EmpresaRepository;
import br.unisul.pweb.diego.trabalho.repositories.VagaRepository;

@Service
public class DbService {

	@Autowired
	private EmpresaRepository empRep;
	@Autowired
	private DepartamentoRepository depRep;
	@Autowired 
	private VagaRepository vagaRep;
	
	
	public void inicializaBancoDeDados() {
		Empresa emp1 = new Empresa(null,"Fariman","Jaguaruna","SC","48999876554");
		Empresa emp2 = new Empresa(null,"Unisul","Tubarão","SC","4836662211");
		
		Departamento d1 = new Departamento(null,"Área de vendas","Diego", emp1);
		Departamento d2 = new Departamento(null,"Área Recursos Humanos","Kelin", emp2);
		
		
		emp1.getDepartamentos().addAll(Arrays.asList(d1));
		emp2.getDepartamentos().addAll(Arrays.asList(d2));
		
		
		empRep.saveAll(Arrays.asList(emp1,emp2));
		depRep.saveAll(Arrays.asList(d1,d2));
		
		
		
	}
	
}
