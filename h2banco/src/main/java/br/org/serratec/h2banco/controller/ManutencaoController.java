package br.org.serratec.h2banco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.h2banco.domain.Manutencao;
import br.org.serratec.h2banco.repository.ManutencaoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/manu")
public class ManutencaoController {

	@Autowired
	private ManutencaoRepository manut;
	
	@GetMapping
	public ResponseEntity <List<Manutencao>>listar(){
		return ResponseEntity.ok(manut.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Manutencao>buscar(@PathVariable Long id){
		Optional<Manutencao> manuOPT = manut.findById(id);
		if(manuOPT.isPresent()) {
			return ResponseEntity.ok(manuOPT.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Manutencao inserir(@Valid @RequestBody Manutencao m) {
			return manut.save(m);
		}
	
}
