package com.smartretail.common.dto;

import lombok.Data;

@Data
public class OrderDto {
    private String orderId;
    private String userId;
    private String productId;
    private int quantity;
}
