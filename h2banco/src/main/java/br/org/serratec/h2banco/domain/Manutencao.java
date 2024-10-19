package br.org.serratec.h2banco.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Manutencao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dataEntrada;

	private LocalDate dataSaida;

	private String obs;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_veiculo")
	private Veiculo veiculo;

	@ManyToMany
	@JoinTable(name = "manu_servi", joinColumns = @JoinColumn(name = "id_manutencao"), inverseJoinColumns = @JoinColumn(name = "id_servic"))
	private List<Servico> servico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Servico> getServico() {
		return servico;
	}

	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate datasaida) {
		this.dataSaida = datasaida;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manutencao other = (Manutencao) obj;
		return Objects.equals(id, other.id);
	}

}
