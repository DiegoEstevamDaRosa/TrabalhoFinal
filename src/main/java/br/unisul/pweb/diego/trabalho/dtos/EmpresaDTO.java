package br.unisul.pweb.diego.trabalho.dtos;

import java.io.Serializable;

import br.unisul.pweb.diego.trabalho.domain.Empresa;

public class EmpresaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
			
	private Integer id;
	private String nome;
	private String cidade;
	private String uf;
	private String telefone;
			
	public EmpresaDTO() {
				
	}
	public EmpresaDTO(Empresa e) {
		this.id = e.getId();
		this.nome = e.getNome();
		this.cidade = e.getCidade();
		this.uf = e.getUf();
		this.telefone = e.getTelefone();
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
		
}
