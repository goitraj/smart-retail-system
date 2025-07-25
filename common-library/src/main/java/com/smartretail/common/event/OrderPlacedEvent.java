package com.smartretail.common.event;

import com.smartretail.common.dto.OrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Event triggered when an order is successfully placed.
 */
@Getter
@Setter
@NoArgsConstructor
public class OrderPlacedEvent extends BaseEvent<OrderDto> {

    public OrderPlacedEvent(OrderDto data) {
        super(data);
    }
}
