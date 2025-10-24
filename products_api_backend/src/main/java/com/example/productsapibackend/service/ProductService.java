package com.example.productsapibackend.service;

import com.example.productsapibackend.entity.Product;
import com.example.productsapibackend.exception.NotFoundException;
import com.example.productsapibackend.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service layer for managing Products.
 */
@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // PUBLIC_INTERFACE
    public List<Product> findAll() {
        /** Returns all products. */
        return productRepository.findAll();
    }

    // PUBLIC_INTERFACE
    public Product findById(Long id) {
        /** Returns product by id or throws NotFoundException. */
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with id " + id + " not found"));
    }

    // PUBLIC_INTERFACE
    public Product create(Product product) {
        /** Creates a new product. ID will be generated. */
        product.setId(null);
        return productRepository.save(product);
    }

    // PUBLIC_INTERFACE
    public Product update(Long id, Product update) {
        /** Updates an existing product by id or throws NotFoundException. */
        Product existing = findById(id);
        existing.setName(update.getName());
        existing.setPrice(update.getPrice());
        existing.setQuantity(update.getQuantity());
        return productRepository.save(existing);
    }

    // PUBLIC_INTERFACE
    public void delete(Long id) {
        /** Deletes a product by id; throws NotFoundException when not found. */
        Product existing = findById(id);
        productRepository.delete(existing);
    }
}
