package br.org.serratec.h2banco.domain;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class PessoaFisica extends Fornecedor {

	@Column
	private String rg;
	
	@Column
	private String orgao;
	
	@Column
	@CPF
	private String cpf;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgao() {
		return orgao;
	}

	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
