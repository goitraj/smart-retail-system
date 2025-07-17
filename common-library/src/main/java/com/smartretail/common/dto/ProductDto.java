package com.smartretail.common.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String id;
    private String name;
    private double price;
    private int quantity;
}
