package com.smartretail.notification.service;

import com.smartretail.common.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    public void sendOrderNotification(OrderDto dto) {
        // Mock notification
        log.info("📢 Sending notification: Order placed for Product ID: {}, Quantity: {}",
                dto.getProductId(), dto.getQuantity());
    }
}
