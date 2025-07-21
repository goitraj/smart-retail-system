package com.smartretail.inventory.service;

import com.smartretail.inventory.entity.Inventory;
import com.smartretail.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private  InventoryRepository repository;

    public Inventory getInventory(String productId) {
        return repository.findById(productId)
                .orElse(Inventory.builder().productId(productId).quantity(0).build());
    }

    public Inventory updateInventory(String productId, int qty) {
        Inventory inv = repository.findById(productId)
                .orElse(Inventory.builder().productId(productId).quantity(0).build());
        inv.setQuantity(qty);
        return repository.save(inv);
    }

    public void decreaseStock(String productId, int qty) {
        Inventory inv = repository.findById(productId).orElseThrow();
        inv.setQuantity(inv.getQuantity() - qty);
        repository.save(inv);
    }
}
