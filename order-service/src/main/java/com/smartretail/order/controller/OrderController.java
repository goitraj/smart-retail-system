package com.smartretail.order.controller;

import com.smartretail.common.dto.OrderDto;
import com.smartretail.order.entity.Order;
import com.smartretail.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody OrderDto dto) {
        return orderService.placeOrder(dto);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderService.getOrder(id);
    }
}
