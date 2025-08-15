package com.gmail.alinakotova102.model;

public enum Priority {
    FAST(1),
    IMMEDIATE(2),
    HIGH(3),
    URGENT(4);

    private int priority;

    Priority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "priority=" + priority +
                '}';
    }
}
