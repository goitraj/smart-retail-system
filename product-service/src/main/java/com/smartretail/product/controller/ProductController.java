package com.smartretail.product.controller;

import com.smartretail.product.entity.Product;
import com.smartretail.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable String id) {
        return service.getProduct(id);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteProduct(id);
    }
}
