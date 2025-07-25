package com.smartretail.notification.consumer;

import com.smartretail.common.dto.OrderDto;
import com.smartretail.common.event.OrderPlacedEvent;
import com.smartretail.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "order-events", groupId = "notification-service")
    public void handleOrderEvent(OrderPlacedEvent event) {
        OrderDto dto = event.getData();
        notificationService.sendOrderNotification(dto);
    }
}
