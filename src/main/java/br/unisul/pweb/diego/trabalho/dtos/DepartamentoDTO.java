package br.unisul.pweb.diego.trabalho.dtos;

import java.io.Serializable;

import br.unisul.pweb.diego.trabalho.domain.Departamento;

public class DepartamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public DepartamentoDTO() {
		
	}
	public DepartamentoDTO(Departamento dt) {
		id = dt.getId();
		nome = dt.getNome();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
