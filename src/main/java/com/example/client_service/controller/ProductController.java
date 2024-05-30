package com.example.client_service.controller;

import com.example.client_service.controller.dto.ProductDto;
import com.example.client_service.error.LocalNotFoundException;
import com.example.client_service.service.ProductService;

import jakarta.validation.Valid;
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

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;

	@GetMapping("/{productId}")
	public Mono<ProductDto> getProduct(@PathVariable("productId") Integer productId) throws LocalNotFoundException {
		return productService.getProduct(productId);
	}

	@PostMapping
	public Mono<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
		return productService.createProduct(productDto);
	}

	@PutMapping("/{productId}")
	public Mono<ProductDto> updateProduct(@PathVariable("productId") Integer productId, @RequestBody ProductDto productDto) {
		return productService.updateProduct(productId, productDto);
	}

	@DeleteMapping("/{productId}")
	public Mono<Void> deleteProduct(@PathVariable("productId") Integer productId) {
		return productService.deleteProduct(productId);
	}
}
