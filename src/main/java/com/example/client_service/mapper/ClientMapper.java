package com.example.client_service.mapper;

import com.example.client_service.controller.dto.ClientDto;
import com.example.client_service.repository.entity.ClientEntity;

public class ClientMapper {
	public static ClientDto mapToClientDto(ClientEntity clientEntity) {
		return new ClientDto(
				clientEntity.getId(),
				clientEntity.getName(),
				clientEntity.getAge(),
				clientEntity.getAddress()
				);
	}
	
	public static ClientEntity mapToClientEntity(ClientDto clientDto) {
		return new ClientEntity(
				clientDto.id(),
				clientDto.name(),
				clientDto.age(),
				clientDto.address()
				);
	}
}
