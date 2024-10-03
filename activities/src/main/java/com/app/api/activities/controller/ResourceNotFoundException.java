package com.app.api.activities.controller;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String  message) {
        super(message);
    }
}
