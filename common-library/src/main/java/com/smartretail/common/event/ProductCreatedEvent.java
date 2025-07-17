package com.smartretail.common.event;

import com.smartretail.common.dto.ProductDto;

public class ProductCreatedEvent  extends BaseEvent<ProductDto> {
    public ProductCreatedEvent(ProductDto data) {
        super(data);
    }
}
