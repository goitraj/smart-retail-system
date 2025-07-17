package com.smartretail.common.dto;

import lombok.Data;

@Data
public class InventoryDto {
    private String productId;
    private int availableQuantity;
}
