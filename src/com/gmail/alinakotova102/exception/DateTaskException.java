package com.gmail.alinakotova102.exception;

import java.time.LocalDate;

public class DateTaskException extends Exception {
    private final LocalDate startData;
    private final LocalDate endData;

    public DateTaskException(LocalDate startData, LocalDate endData) {
        this.startData = startData;
        this.endData = endData;
    }

    @Override
    public String getMessage() {
        return "The end date " + " [" + endData + "] " +
                "cannot be earlier than the start" + " [" + startData + "]";
    }
}
