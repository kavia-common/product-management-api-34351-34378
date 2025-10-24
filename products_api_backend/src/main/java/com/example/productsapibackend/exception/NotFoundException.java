package com.example.productsapibackend.exception;

/**
 * Exception thrown when an entity is not found.
 */
public class NotFoundException extends RuntimeException {
    // PUBLIC_INTERFACE
    public NotFoundException(String message) {
        /** Construct a NotFoundException with a message. */
        super(message);
    }
}
