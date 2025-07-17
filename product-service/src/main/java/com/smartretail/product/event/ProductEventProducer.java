package com.smartretail.product.event;

import com.smartretail.common.dto.ProductDto;
import com.smartretail.common.event.ProductCreatedEvent;
import com.smartretail.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendProductCreatedEvent(Product product) {
        ProductDto dto = ProductDto.builder()
                .id(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .description(product.getDescription())
                .build();
        ProductCreatedEvent event = new ProductCreatedEvent(dto);
        kafkaTemplate.send("product-events", event);
    }
}
