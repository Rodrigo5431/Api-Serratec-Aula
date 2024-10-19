package br.org.serratec.h2banco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.h2banco.domain.Servico;
import br.org.serratec.h2banco.repository.ServicoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/servico")
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	
	@Operation(summary = "Lista todos os servicos", description = "A resposta lista os dados dos "
			+ "servicos id, descricao, valor")
	@ApiResponses(
		value = {
			@ApiResponse(responseCode = "200",
					content = {@Content(schema = @Schema(implementation = Servico.class), mediaType = "application/json")},
					description = "Retorna todos os clientes"),
			@ApiResponse(responseCode = "401", description = "Erro na autenticação"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") 
		}
	) 
	@GetMapping
	public ResponseEntity<List<Servico>> listar() {
		return ResponseEntity.ok(servicoRepository.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Servico> buscar(@PathVariable Long id) {
		Optional<Servico> servicoOpt = servicoRepository.findById(id);
		if (servicoOpt.isPresent()) {
			return ResponseEntity.ok(servicoOpt.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@Operation(summary = "Lista todos os servicos", description = "A resposta lista os dados dos "
			+ "servicos id, descricao, valor")
	@ApiResponses(
		value = {
			@ApiResponse(responseCode = "200",
					content = {@Content(schema = @Schema(implementation = Servico.class), mediaType = "application/json")},
					description = "Retorna todos os clientes"),
			@ApiResponse(responseCode = "401", description = "Erro na autenticação"),
			@ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
			@ApiResponse(responseCode = "505", description = "Exceção interna da aplicação") 
		}
	) 
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico inserir(@Valid @RequestBody Servico servico) {
		servico = servicoRepository.save(servico);
		return servico;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Servico> alterar(@PathVariable Long id,
			@Valid @RequestBody Servico servico) {
		if (!servicoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		servico.setId(id);
		servico = servicoRepository.save(servico);
		return ResponseEntity.ok(servico);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!servicoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		servicoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}

