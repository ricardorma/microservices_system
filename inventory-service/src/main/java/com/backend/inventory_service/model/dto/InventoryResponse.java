package com.backend.inventory_service.model.dto;

public record InventoryResponse(Long id, String sku, Long quantity) {
}
