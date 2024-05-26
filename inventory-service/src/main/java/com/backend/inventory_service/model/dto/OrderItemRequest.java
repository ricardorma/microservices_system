package com.backend.inventory_service.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItemRequest {

    private Long id;
    private String sku;
    private Double price;
    private Long quantity;
}

