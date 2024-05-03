package com.backend.products_service.services;

import com.backend.products_service.model.dto.ProductRequest;
import com.backend.products_service.model.dto.ProductResponse;
import com.backend.products_service.model.entities.Product;
import com.backend.products_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(ProductRequest productRequest) {
        var product = Product.builder()
                .sku(productRequest.getSku())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .status(productRequest.isStatus())
                .build();

        productRepository.save(product);

        log.info("Product added: {}", product);
    }

    public List<ProductResponse> getAllProducts() {
        var products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .sku(product.getSku())
                .status(product.isStatus())
                .price(product.getPrice())
                .description(product.getDescription())
                .name(product.getName())
                .build();
    }
}
