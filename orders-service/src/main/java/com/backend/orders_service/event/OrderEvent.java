package com.backend.orders_service.event;

import com.backend.orders_service.enums.OrderStatus;

public record OrderEvent(String orderNumber, int itemsCount, OrderStatus orderStatus) {
}
