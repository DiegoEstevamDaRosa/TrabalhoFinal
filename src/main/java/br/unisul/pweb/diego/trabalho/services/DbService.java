package br.unisul.pweb.diego.trabalho.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.unisul.pweb.diego.trabalho.repositories.DepartamentoRepository;
import br.unisul.pweb.diego.trabalho.repositories.EmpresaRepository;
import br.unisul.pweb.diego.trabalho.repositories.VagaRepository;

public class DbService {

	@Autowired
	private EmpresaRepository empRep;
	@Autowired
	private DepartamentoRepository depRep;
	@Autowired 
	private VagaRepository vagaRep;
	
	
	public void inicializaBancoDeDados() {
	
	}
	
}
