package com.example.client_service.controller;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client_service.controller.dto.ClientDto;
import com.example.client_service.error.LocalNotFoundException;
import com.example.client_service.service.ClientService;

import jakarta.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {
	
	private final ClientService clientService;

	@GetMapping("/{clientId}")
	public Mono<ClientDto> getClient(@PathVariable("clientId") Integer clientId) throws LocalNotFoundException {
		return clientService.getClient(clientId);
	}

	@PostMapping
	public Mono<ClientDto> createClient(@Valid @RequestBody ClientDto clientDto) {
		return clientService.createClient(clientDto);
	}

	@PutMapping("/{clientId}")
	public Mono<ClientDto> updateClient(@PathVariable("clientId") Integer clientId, @RequestBody ClientDto clientDto) {
		return clientService.updateClient(clientId, clientDto);
	}

	@DeleteMapping("/{clientId}")
	public Mono<Void> deleteClient(@PathVariable("clientId") Integer clientId) {
		return clientService.deleteClient(clientId);
	}
}
