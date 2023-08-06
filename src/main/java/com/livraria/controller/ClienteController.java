package com.livraria.controller;


import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.model.Cliente;
import com.livraria.repository.ClienteRepository;


@RestController
@RequestMapping
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	
	@GetMapping("/cliente/{id}")
	public Cliente buscarCliente(@PathVariable(value = "id") long id) {
		return clienteRepository.findById(id);
	}

	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		cliente.setDataRegistro(LocalDateTime.now());
		System.out.println(cliente);
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/clientes")
	public Cliente alterarCliente(@RequestBody Cliente cliente) {
		cliente.setDataRegistro(LocalDateTime.now());
		return clienteRepository.save(cliente);
	}
	
	
	@DeleteMapping("/clientes")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deletar(@RequestBody Cliente id) {
		clienteRepository.delete(id);
	}
	
}
