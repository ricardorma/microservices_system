package com.backend.products_service.controller;

import com.backend.products_service.model.dto.ProductRequest;
import com.backend.products_service.model.dto.ProductResponse;
import com.backend.products_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addProduct(@RequestBody ProductRequest productRequest) {
        this.productService.addProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Producto agregado correctamente");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return this.productService.getAllProducts();
    }
}
