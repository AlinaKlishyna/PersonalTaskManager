package com.gmail.alinakotova102.exception;

public class NotFoundException extends Exception {
    private final Object obj;

    public NotFoundException(Object obj) {
        super("Object not found: ");
        this.obj = obj;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " [" + obj + "]";
    }
}
