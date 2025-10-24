package com.example.productsapibackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

/**
 * Product entity representing a product in the catalog.
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is required")
    @Column(nullable = false)
    private String name;

    @DecimalMin(value = "0.0", inclusive = true, message = "price must be >= 0")
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal price;

    @Min(value = 0, message = "quantity must be >= 0")
    @Column(nullable = false)
    private Integer quantity;

    public Product() {
    }

    public Product(Long id, String name, BigDecimal price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    // PUBLIC_INTERFACE
    public void setId(Long id) {
        /** Sets the ID. Usually assigned by the database. */
        this.id = id;
    }

    // PUBLIC_INTERFACE
    public String getName() {
        /** Returns the product name. */
        return name;
    }

    // PUBLIC_INTERFACE
    public void setName(String name) {
        /** Sets the product name. */
        this.name = name;
    }

    // PUBLIC_INTERFACE
    public BigDecimal getPrice() {
        /** Returns the product price. */
        return price;
    }

    // PUBLIC_INTERFACE
    public void setPrice(BigDecimal price) {
        /** Sets the product price. */
        this.price = price;
    }

    // PUBLIC_INTERFACE
    public Integer getQuantity() {
        /** Returns the inventory quantity. */
        return quantity;
    }

    // PUBLIC_INTERFACE
    public void setQuantity(Integer quantity) {
        /** Sets the inventory quantity. */
        this.quantity = quantity;
    }
}
