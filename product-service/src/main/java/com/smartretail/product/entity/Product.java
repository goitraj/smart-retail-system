package com.smartretail.product.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    private String productId;
    private String name;
    private int quantity;
    private String description;
    private double price;
}
