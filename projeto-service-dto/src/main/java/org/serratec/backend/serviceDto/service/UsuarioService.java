package org.serratec.backend.serviceDto.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.serratec.backend.serviceDto.config.MailConfig;
import org.serratec.backend.serviceDto.domain.Perfil;
import org.serratec.backend.serviceDto.domain.Usuario;
import org.serratec.backend.serviceDto.domain.UsuarioPerfil;
import org.serratec.backend.serviceDto.dto.UsuarioDTO;
import org.serratec.backend.serviceDto.dto.UsuarioInserirDTO;
import org.serratec.backend.serviceDto.exception.EmailException;
import org.serratec.backend.serviceDto.exception.SenhaException;
import org.serratec.backend.serviceDto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private MailConfig mailConfig;
	
	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		for(Usuario usuario: usuarios) {
			usuariosDTO.add(new UsuarioDTO(usuario));
		}
		/*
		List<UsuarioDTO> usuariosDTO = usuarios.stream().map(UsuarioDTO::new).toList();
		*/
		return usuariosDTO;
	}
	
	public Optional<Usuario> buscar(Long id) {
		return usuarioRepository.findById(id);
	}
	
	@Transactional
	public UsuarioDTO inserir(UsuarioInserirDTO usuarioInserirDTO) throws EmailException, SenhaException {
		if (!usuarioInserirDTO.getSenha().equals(usuarioInserirDTO.getConfirmaSenha())) {
			throw new SenhaException("Senha e Confirma Senha não são iguais");
		}
		
		
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setSenha(encoder.encode(usuarioInserirDTO.getSenha()));
		
		
		Set<UsuarioPerfil> perfis = new HashSet<>();
		for (Perfil perfil: usuarioInserirDTO.getPerfis()) {
			perfil = perfilService.buscar(perfil.getId());
			UsuarioPerfil usuarioPerfil = new UsuarioPerfil(usuario, perfil, LocalDate.now());
			perfis.add(usuarioPerfil);
		}
		usuario.setUsuariosPerfil(perfis);
		
		usuario = usuarioRepository.save(usuario);
		
		mailConfig.sendEmail(usuario.getEmail(), "cadastro", usuario.toString());
		
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return usuarioDTO;
	}
	
}
	
