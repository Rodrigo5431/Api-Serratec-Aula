package org.serratec.backend.serviceDto.repository;

import org.serratec.backend.serviceDto.domain.UsuarioPerfil;
import org.serratec.backend.serviceDto.domain.UsuarioPerfilPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, UsuarioPerfilPK> {

	
}
