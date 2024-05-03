package com.backend.orders_service.model.dto;

public record OrderItemResponse(Long id, String sku, Double price, Long quantity) {
}
