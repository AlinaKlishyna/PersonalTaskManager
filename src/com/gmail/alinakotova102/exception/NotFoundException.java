package com.gmail.alinakotova102.exception;

import com.gmail.alinakotova102.util.DisplayUtil;

public class NotFoundException extends Exception {
    public NotFoundException() {
    }

    public NotFoundException(Object o) {
        DisplayUtil.view("I couldn't find the object : " + o + ";");
    }

    @Override
    public String getMessage() {
        return "Ops! I don't found :(";
    }
}
