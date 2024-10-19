package br.org.serratec.h2banco.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class PessoaJuridica extends Fornecedor {

	@Column
	private String razao;
	
	@Column
	private String cnpj;
	
	@Column
	private String ins;

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIns() {
		return ins;
	}

	public void setIns(String ins) {
		this.ins = ins;
	}
	
	
}
