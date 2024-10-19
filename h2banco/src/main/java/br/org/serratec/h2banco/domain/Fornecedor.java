package br.org.serratec.h2banco.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length =50)
	@NotBlank(message="deve ser preeenche")
	@Size(min=2, max =50, message="deve ter mais que 2 e menos q 50")
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String telefone;
	
}
