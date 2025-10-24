package com.example.productsapibackend.controller;

import com.example.productsapibackend.entity.Product;
import com.example.productsapibackend.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller exposing CRUD endpoints for products.
 */
@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "CRUD operations for products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // PUBLIC_INTERFACE
    @GetMapping
    @Operation(summary = "List products", description = "Returns a list of all products")
    public ResponseEntity<List<Product>> getAll() {
        /** GET /products - returns all products. */
        return ResponseEntity.ok(productService.findAll());
    }

    // PUBLIC_INTERFACE
    @GetMapping("/{id}")
    @Operation(summary = "Get product by id", description = "Returns a product for the given id")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        /** GET /products/{id} - returns product by id or 404. */
        return ResponseEntity.ok(productService.findById(id));
    }

    // PUBLIC_INTERFACE
    @PostMapping
    @Operation(summary = "Create product", description = "Creates a new product")
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        /** POST /products - creates a new product; returns 201. */
        Product created = productService.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUBLIC_INTERFACE
    @PutMapping("/{id}")
    @Operation(summary = "Update product", description = "Updates an existing product by id")
    public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product product) {
        /** PUT /products/{id} - updates a product; returns 200. */
        Product updated = productService.update(id, product);
        return ResponseEntity.ok(updated);
    }

    // PUBLIC_INTERFACE
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product", description = "Deletes a product by id")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        /** DELETE /products/{id} - deletes a product; returns 204. */
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
