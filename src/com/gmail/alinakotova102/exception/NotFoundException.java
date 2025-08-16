package com.gmail.alinakotova102.exception;

import com.gmail.alinakotova102.util.DisplayUtil;

public class NotFoundException extends Exception {
    public NotFoundException(Object o) {
        DisplayUtil.console("I couldn't find the object : " + o + ";");
    }
}
