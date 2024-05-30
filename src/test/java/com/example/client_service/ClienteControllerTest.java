package com.example.client_service;

import com.example.client_service.controller.ClientController;
import com.example.client_service.controller.dto.ClientDto;
import com.example.client_service.error.LocalNotFoundException;
import com.example.client_service.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class ClientControllerTest {

    private ClientService clientServiceMock;
    private ClientController clientController;

    @BeforeEach
    void setUp() throws LocalNotFoundException {
        clientServiceMock = Mockito.mock(ClientService.class);
        clientController = new ClientController(clientServiceMock);

        ClientDto mockClient = new ClientDto(1, "Lugo", 30, "Lima");

        Mockito.when(clientServiceMock.getClient(1)).thenReturn(Mono.just(mockClient));
        Mockito.when(clientServiceMock.createClient(Mockito.any(ClientDto.class))).thenReturn(Mono.just(mockClient));
        Mockito.when(clientServiceMock.updateClient(Mockito.eq(1), Mockito.any(ClientDto.class))).thenReturn(Mono.just(mockClient));
        Mockito.when(clientServiceMock.deleteClient(1)).thenReturn(Mono.empty());
    }

    @Test
    void getClientWithValidId() throws LocalNotFoundException {
        Mono<ClientDto> response = clientController.getClient(1);
        
        StepVerifier.create(response)
                .expectNextMatches(client -> client.name().equals("Lugo"))
                .verifyComplete();
    }

    @Test
    void createClient() {
        ClientDto newClient = new ClientDto(null, "Lugo", 30, "Lima");

        Mono<ClientDto> response = clientController.createClient(newClient);
        
        StepVerifier.create(response)
                .expectNextMatches(client -> client.name().equals("Lugo"))
                .verifyComplete();
    }

    @Test
    void updateClientWithValidId() {
        ClientDto updatedClient = new ClientDto(null, "Jaime", 28, "Huacho");

        Mono<ClientDto> response = clientController.updateClient(1, updatedClient);
        
        StepVerifier.create(response)
                .expectNextMatches(client -> client.name().equals("Lugo"))
                .verifyComplete();
    }

    @Test
    void deleteClientWithValidId() {
        Mono<Void> response = clientController.deleteClient(1);
        
        StepVerifier.create(response)
                .verifyComplete();
    }

    @Test
    void getClientWithInvalidId() throws LocalNotFoundException {
        Mockito.when(clientServiceMock.getClient(99)).thenReturn(Mono.empty());

        Mono<ClientDto> response = clientController.getClient(99);

        StepVerifier.create(response)
                .expectComplete()
                .verify();
    }
}
