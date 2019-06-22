package br.unisul.pweb.diego.trabalho.dtos;

import java.io.Serializable;

import br.unisul.pweb.diego.trabalho.domain.Vaga;

public class VagaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Double salario;
	private String nomeCargo;
	private String nvEscolaridade;
	
	public VagaDTO() {
		
	}
	public VagaDTO(Vaga v) {
		this.id = v.getId();
		this.salario = v.getSalario();
		this.nomeCargo = v.getNomeCargo();
		this.nvEscolaridade = v.getNvEscolaridade();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public String getNomeCargo() {
		return nomeCargo;
	}
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
	public String getNvEscolaridade() {
		return nvEscolaridade;
	}
	public void setNvEscolaridade(String nvEscolaridade) {
		this.nvEscolaridade = nvEscolaridade;
	}
	
}
