package com.smartretail.order.service;

import com.smartretail.common.dto.OrderDto;
import com.smartretail.common.event.OrderPlacedEvent;
import com.smartretail.order.entity.Order;
import com.smartretail.order.event.OrderEventPublisher;
import com.smartretail.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderEventPublisher publisher;

    public Order placeOrder(OrderDto dto) {
        Order order = Order.builder()
                .orderId(UUID.randomUUID().toString())
                .productId(dto.getProductId())
                .quantity(dto.getQuantity())
                .status("PENDING")
                .build();

        Order saved = repository.save(order);

        // Publish event
        publisher.publishOrderPlaced(new OrderPlacedEvent(dto));

        return saved;
    }

    public Order getOrder(String id) {
        return repository.findById(id).orElseThrow();
    }
}
