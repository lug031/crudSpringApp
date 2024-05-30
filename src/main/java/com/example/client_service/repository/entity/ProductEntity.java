package com.example.client_service.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("product")
public class ProductEntity {

	@Id
	Integer id;
	
	@NotBlank(message="Please add the name")
	String name;
	
	@NotBlank(message="Please add the price")
	@Positive
	@DecimalMax(value = "1000.00")
	Double price;
	
	@NotBlank(message="Please add the brand")
	String brand;
}
