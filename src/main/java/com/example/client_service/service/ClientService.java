package com.example.client_service.service;

import com.example.client_service.controller.dto.ClientDto;
import com.example.client_service.error.LocalNotFoundException;

import reactor.core.publisher.Mono;

public interface ClientService {
	
	Mono<ClientDto> getClient(Integer clientId) throws LocalNotFoundException;
	
	Mono<ClientDto> createClient(ClientDto clientDto);
	
	Mono<ClientDto> updateClient(Integer clientId, ClientDto clientDto);
	
	Mono<Void> deleteClient(Integer clientId);
	
	Mono<Boolean> clientExists(Integer clientId);
}
