package org.serratec.backend.serviceDto.repository;

import org.serratec.backend.serviceDto.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	Endereco findByCep(String cep);
}
