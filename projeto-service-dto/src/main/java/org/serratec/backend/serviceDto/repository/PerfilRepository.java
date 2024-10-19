package org.serratec.backend.serviceDto.repository;

import org.serratec.backend.serviceDto.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{

	
}
