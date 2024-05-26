package com.backend.products_service.controller;

import com.backend.products_service.model.dto.ProductRequest;
import com.backend.products_service.model.dto.ProductResponse;
import com.backend.products_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> addProduct(@RequestBody ProductRequest productRequest) {
        this.productService.addProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Producto agregado correctamente");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<ProductResponse> getAllProducts() {
        return this.productService.getAllProducts();
    }
}
