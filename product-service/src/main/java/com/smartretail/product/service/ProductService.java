package com.smartretail.product.service;

import com.smartretail.product.entity.Product;
import com.smartretail.product.repository.ProductRepository;
import com.smartretail.product.event.ProductEventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductEventProducer eventProducer;

    public Product createProduct(Product product) {
        Product saved = repository.save(product);
        eventProducer.sendProductCreatedEvent(saved);
        return saved;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProduct(String productId) {
        return repository.findById(productId).orElseThrow();
    }

    public Product updateProduct(Product product) {
        // Optionally send update event
        return repository.save(product);
    }

    public void deleteProduct(String productId) {
        repository.deleteById(productId);
    }
}
