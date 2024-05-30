package com.example.client_service;

import com.example.client_service.controller.ProductController;
import com.example.client_service.controller.dto.ProductDto;
import com.example.client_service.error.LocalNotFoundException;
import com.example.client_service.service.ProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class ProductControllerTest {

    private ProductService productServiceMock;
    private ProductController productController;

    @BeforeEach
    void setUp() throws LocalNotFoundException {
        productServiceMock = Mockito.mock(ProductService.class);
        productController = new ProductController(productServiceMock);

        ProductDto mockProduct = new ProductDto(1, "Jabon", 2.5, "Spa");

        Mockito.when(productServiceMock.getProduct(1)).thenReturn(Mono.just(mockProduct));
        Mockito.when(productServiceMock.createProduct(Mockito.any(ProductDto.class))).thenReturn(Mono.just(mockProduct));
        Mockito.when(productServiceMock.updateProduct(Mockito.eq(1), Mockito.any(ProductDto.class))).thenReturn(Mono.just(mockProduct));
        Mockito.when(productServiceMock.deleteProduct(1)).thenReturn(Mono.empty());
    }

    @Test
    void getProductWithValidId() throws LocalNotFoundException {
        Mono<ProductDto> response = productController.getProduct(1);
        
        StepVerifier.create(response)
                .expectNextMatches(product -> product.name().equals("Jabon"))
                .verifyComplete();
    }

    @Test
    void createProduct() {
    	ProductDto newProduct = new ProductDto(null, "Jabon", 2.5, "Spa");

        Mono<ProductDto> response = productController.createProduct(newProduct);
        
        StepVerifier.create(response)
                .expectNextMatches(product -> product.name().equals("Jabon"))
                .verifyComplete();
    }

    @Test
    void updateProductWithValidId() {
    	ProductDto updatedProduct = new ProductDto(null, "Arroz", 3.6, "Tradicional");

        Mono<ProductDto> response = productController.updateProduct(1, updatedProduct);
        
        StepVerifier.create(response)
                .expectNextMatches(product -> product.name().equals("Jabon"))
                .verifyComplete();
    }

    @Test
    void deleteProductWithValidId() {
        Mono<Void> response = productController.deleteProduct(1);
        
        StepVerifier.create(response)
                .verifyComplete();
    }

    @Test
    void getProductWithInvalidId() throws LocalNotFoundException {
        Mockito.when(productServiceMock.getProduct(99)).thenReturn(Mono.empty());

        Mono<ProductDto> response = productController.getProduct(99);

        StepVerifier.create(response)
                .expectComplete()
                .verify();
    }
}
