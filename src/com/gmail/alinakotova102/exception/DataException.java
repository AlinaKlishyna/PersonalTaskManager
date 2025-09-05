package com.gmail.alinakotova102.exception;

public class DataException extends Exception {
    private final String data;

    public DataException(String message, String data) {
        super(message);
        this.data = data;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " [" + data + "]";
    }
}
