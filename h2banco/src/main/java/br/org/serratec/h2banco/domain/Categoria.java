package br.org.serratec.h2banco.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.org.serratec.h2banco.exception.EnumValidationException;

public enum Categoria {

	HATCH,SEDAN,MINIVAN,SUV,PICAPE;
	
	@JsonCreator
	public static Categoria verifica(String valor) throws EnumValidationException{
		for (Categoria c : values()) {
			if (valor.equals(c.name())) {
				return c;
			}
		}
		throw new EnumValidationException("Catewgoria incorreta");
	}
}
