package com.example.productsapibackend.repository;

import com.example.productsapibackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Product entity CRUD operations.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // PUBLIC_INTERFACE
    // Default JpaRepository provides standard CRUD methods.
}
