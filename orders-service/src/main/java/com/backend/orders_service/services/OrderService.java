package com.backend.orders_service.services;

import com.backend.orders_service.model.dto.*;
import com.backend.orders_service.model.entities.Order;
import com.backend.orders_service.model.entities.OrderItems;
import com.backend.orders_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public void placeOrder(OrderRequest orderRequest) {

        BaseResponse result = this.webClientBuilder.build().
                post().
                uri("http://localhost:8080/api/inventory/in-stock").
                bodyValue(orderRequest.getOrderItems()).
                retrieve().bodyToMono(BaseResponse.class).block();

        if (result != null && !result.hasErrors()) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setOrderItems(orderRequest.getOrderItems().stream().
                    map(value -> mapOrderItemRequestToOrderItem(value, order)).toList());
            this.orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Some of the products are not in stock");
        }
    }

    private OrderItems mapOrderItemRequestToOrderItem(OrderItemRequest orderItemRequest, Order order) {
        return OrderItems.builder().id(orderItemRequest.getId()).
                sku(orderItemRequest.getSku()).
                price(orderItemRequest.getPrice()).
                quantity(orderItemRequest.getQuantity()).
                order(order).build();
    }

    public List<OrderResponse> getOrders() {
        List<Order> orders = this.orderRepository.findAll();
        return orders.stream().map(this::mapOrderListToOrderResponseList).toList();
    }

    private OrderResponse mapOrderListToOrderResponseList(Order order) {
        return new OrderResponse(order.getId(), order.getOrderNumber(),
                order.getOrderItems().stream().map(this::mapToOrderItemResponse).toList());
    }

    private OrderItemResponse mapToOrderItemResponse(OrderItems orderItems) {
        return new OrderItemResponse(orderItems.getId(), orderItems.getSku(), orderItems.getPrice(), orderItems.getQuantity());
    }
}
