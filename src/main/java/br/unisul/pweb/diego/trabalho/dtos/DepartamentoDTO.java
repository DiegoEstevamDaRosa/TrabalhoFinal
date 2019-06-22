package br.unisul.pweb.diego.trabalho.dtos;

import java.io.Serializable;

import br.unisul.pweb.diego.trabalho.domain.Departamento;

public class DepartamentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nomeDept;
	private String nomeGerente;
	
	public DepartamentoDTO() {
		
	}
	public DepartamentoDTO(Departamento d) {
		this.id = d.getId();
		this.nomeDept = d.getNomeDept();
		this.nomeGerente = d.getNomeGerente();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeDept() {
		return nomeDept;
	}
	public void setNomeDept(String nomeDept) {
		this.nomeDept = nomeDept;
	}
	public String getNomeGerente() {
		return nomeGerente;
	}
	public void setNomeGerente(String nomeGerente) {
		this.nomeGerente = nomeGerente;
	}
	
}
