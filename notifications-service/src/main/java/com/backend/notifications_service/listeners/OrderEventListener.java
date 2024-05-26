package com.backend.notifications_service.listeners;

import com.backend.notifications_service.event.OrderEvent;
import com.backend.notifications_service.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderEventListener {

    @KafkaListener(topics = "orders-event")
    public void handleOrdersNotification(String mensaje) {
        var orderEvent = JsonUtils.fromJson(mensaje, OrderEvent.class);
        log.info("Orden {} recibida. Numero {} con {} items", orderEvent.orderStatus(), orderEvent.orderNumber(), orderEvent.itemsCount());
    }

}
