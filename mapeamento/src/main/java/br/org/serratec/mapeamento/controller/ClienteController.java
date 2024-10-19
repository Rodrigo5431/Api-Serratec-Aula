package br.org.serratec.mapeamento.controller;

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

import br.org.serratec.mapeamento.domain.Cliente;
import br.org.serratec.mapeamento.repository.ClienteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List <Cliente> listar(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente>buscar(@PathVariable Long id){
		Optional<Cliente> clienteOpt = clienteRepository.findById(id);
		if(clienteOpt.isPresent()) {
			return ResponseEntity.ok(clienteOpt.get());
		}
		else {
		return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente inserir(@Valid @RequestBody Cliente cliente) {
		cliente = clienteRepository.save(cliente);
		return cliente;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente>atualizar(@PathVariable Long id,@Valid @RequestBody Cliente cliente){
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		else {
			cliente.setId_cliente(id);
			cliente = clienteRepository.save(cliente);
			return ResponseEntity.ok(cliente);
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		if (clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.notFound().build();
		
		}
	}
	
	
}
