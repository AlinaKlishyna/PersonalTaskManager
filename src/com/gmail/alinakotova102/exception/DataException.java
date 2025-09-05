package com.gmail.alinakotova102.exception;

public class DataException extends Exception {
    private String data;

    public DataException(String message, String data) {
        super(message);
        this.data = data;
    }

    @Override
    public String getMessage() {
        return "The data is incorrect!";
    }
}
