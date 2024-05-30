package com.example.client_service.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("client")
public class ClientEntity {

	@Id
	Integer id;
	
	@NotBlank(message = "Please add the name")
	String name;
	
	@NotBlank(message="Please add the age")
	@Min(18)
	Integer age;
	
	@NotBlank(message="Please add the address")
	String address;
}
