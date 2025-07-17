package com.smartretail.common.event;

import com.smartretail.common.dto.InventoryDto;

public class InventoryUpdatedEvent extends BaseEvent<InventoryDto> {
    public InventoryUpdatedEvent(InventoryDto data) {
        super(data);
    }
}
