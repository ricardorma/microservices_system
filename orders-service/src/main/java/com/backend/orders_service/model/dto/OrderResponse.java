package com.backend.orders_service.model.dto;

import java.util.List;

public record OrderResponse(Long id, String orderNumber, List<OrderItemResponse> orderItemResponse) {
}
