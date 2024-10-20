package org.serratec.backend.serviceDto.dto;

import java.util.HashSet;
import java.util.Set;

import org.serratec.backend.serviceDto.domain.Perfil;
import org.serratec.backend.serviceDto.domain.Usuario;
import org.serratec.backend.serviceDto.domain.UsuarioPerfil;

public class UsuarioDTO {

	private Long id;

	private String nome;

	private String email;

	private Set<Perfil> perfis;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.perfis = new HashSet<>();
		for (UsuarioPerfil usuarioPerfil : usuario.getUsuariosPerfil()) {
			this.perfis.add(usuarioPerfil.getId().getPerfil());

		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

}
