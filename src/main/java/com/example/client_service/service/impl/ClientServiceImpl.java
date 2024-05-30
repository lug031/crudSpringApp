package com.example.client_service.service.impl;

import org.springframework.stereotype.Service;

import com.example.client_service.controller.dto.ClientDto;
import com.example.client_service.error.LocalNotFoundException;
import com.example.client_service.mapper.ClientMapper;
import com.example.client_service.repository.ClientRepository;
import com.example.client_service.repository.entity.ClientEntity;
import com.example.client_service.service.ClientService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService{

	private final ClientRepository clientRepository;
	
	@Override
    public Mono<ClientDto> getClient(Integer clientId) throws LocalNotFoundException {
        return clientRepository.findById(clientId)
                .switchIfEmpty(Mono.error(new LocalNotFoundException("Client not found with id " + clientId)))
                .map(ClientMapper::mapToClientDto);
    }

    @Override
    public Mono<ClientDto> createClient(ClientDto clientDto) {
        ClientEntity clientEntity = ClientMapper.mapToClientEntity(clientDto);
        return clientRepository.save(clientEntity)
                .map(ClientMapper::mapToClientDto);
    }

    @Override
    public Mono<ClientDto> updateClient(Integer clientId, ClientDto clientDto) {
        ClientEntity clientEntity = ClientMapper.mapToClientEntity(clientDto);
        clientEntity.setId(clientId);
        return clientRepository.save(clientEntity)
                .map(ClientMapper::mapToClientDto);
    }

    @Override
    public Mono<Void> deleteClient(Integer clientId) {
        return clientRepository.findById(clientId)
                .switchIfEmpty(Mono.error(new LocalNotFoundException("Client not found with id " + clientId)))
                .flatMap(clientRepository::delete);
    }

    @Override
    public Mono<Boolean> clientExists(Integer clientId) {
        return clientRepository.existsById(clientId);
    }

}
