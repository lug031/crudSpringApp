package com.example.client_service.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.example.client_service.repository.entity.ClientEntity;

public interface ClientRepository extends R2dbcRepository<ClientEntity, Integer>{

}
