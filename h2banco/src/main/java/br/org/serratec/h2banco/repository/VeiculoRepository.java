package br.org.serratec.h2banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.h2banco.domain.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
