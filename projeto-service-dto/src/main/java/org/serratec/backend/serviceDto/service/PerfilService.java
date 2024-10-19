package org.serratec.backend.serviceDto.service;

import java.util.Optional;

import org.serratec.backend.serviceDto.domain.Perfil;
import org.serratec.backend.serviceDto.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;
	
	public Perfil buscar(Long id) {
		Optional<Perfil> perfilOpt = perfilRepository.findById(id);
		return perfilOpt.get();
	}
	
}
