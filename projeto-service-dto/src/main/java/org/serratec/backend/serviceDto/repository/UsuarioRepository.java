package org.serratec.backend.serviceDto.repository;

import org.serratec.backend.serviceDto.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

	Usuario findByEmail(String email);
}
