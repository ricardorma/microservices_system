package com.backend.notifications_service.event;

import com.backend.notifications_service.enums.OrderStatus;

public record OrderEvent(String orderNumber, int itemsCount, OrderStatus orderStatus) {
}
