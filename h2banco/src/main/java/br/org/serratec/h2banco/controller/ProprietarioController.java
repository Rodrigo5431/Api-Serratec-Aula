package br.org.serratec.h2banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.h2banco.domain.Proprietario;
import br.org.serratec.h2banco.repository.ProprietarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController {

	@Autowired
	public ProprietarioRepository proprietarioRepository;
	
	@GetMapping
	private	ResponseEntity<List<Proprietario>>listar(){
		return ResponseEntity.ok(proprietarioRepository.findAll());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Proprietario inserir(@Valid @RequestBody Proprietario propri){
		return proprietarioRepository.save(propri);
	}
	
	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Proprietario>inserirVarios(@Valid @RequestBody List<Proprietario> propr){
		return proprietarioRepository.saveAll(propr);
	}
	
}
