package com.smartretail.inventory.controller;

import com.smartretail.inventory.entity.Inventory;
import com.smartretail.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @GetMapping("/{productId}")
    public Inventory getStock(@PathVariable String productId) {
        return service.getInventory(productId);
    }

    @PutMapping("/{productId}")
    public Inventory updateStock(@PathVariable String productId, @RequestParam int quantity) {
        return service.updateInventory(productId, quantity);
    }
}
