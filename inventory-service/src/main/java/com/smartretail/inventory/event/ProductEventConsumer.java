package com.smartretail.inventory.event;

import com.smartretail.common.dto.ProductDto;
import com.smartretail.common.event.ProductCreatedEvent;
import com.smartretail.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventConsumer {

    private final InventoryService service;

    @KafkaListener(topics = "product-events", groupId = "inventory-service")
    public void consumeProductCreated(ProductCreatedEvent event) {
        ProductDto product = event.getData();
        service.updateInventory(product.getId(), product.getQuantity());
        System.out.println("Inventory initialized for product: " + product.getId());
    }
}

