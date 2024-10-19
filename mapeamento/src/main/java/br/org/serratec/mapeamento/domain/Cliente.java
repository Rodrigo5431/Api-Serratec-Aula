package br.org.serratec.mapeamento.domain;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id_cliente;

	@Size(max=60)
	@NotBlank(message ="preencha nome")
	@Column(name = "nome", nullable = true, length = 100)
	private String nome;

	@CPF(message ="invalido")
	@NotBlank(message = "preencha cpf")
	@Column(name = "cpf", nullable = false, length = 40)
	private String cpf;

	@Email(message = "invalido")
	@NotBlank(message = "preencha email")
	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Past
	@NotNull
	@Column(name = "data_nascimento", nullable = false, length = 50)
	private LocalDate dataNascimento;

	public Cliente(Long id_cliente, String nome, String cpf, String email, LocalDate dataNascimento) {
		super();
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
