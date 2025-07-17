package com.smartretail.common.event;

import com.smartretail.common.dto.OrderDto;

public class OrderCreatedEvent extends BaseEvent<OrderDto> {
    public OrderCreatedEvent(OrderDto data) {
        super(data);
    }
}
