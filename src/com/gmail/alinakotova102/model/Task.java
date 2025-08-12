package com.gmail.alinakotova102.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Task implements Serializable {
    public static final long serialVersionUUID = 1L;
    private final String ID;
    private String title;
    private String description;
    private Priority priority;
    private LocalDate creationDate;
    private LocalDate executionDate;
    private Person author;
    private Person performer;
    private Status status;

    public Task() {
        ID = UUID.randomUUID().toString();
    }

    public Task(String title, String description, Priority priority, LocalDate creationDate, LocalDate executionDate,
                Person author, Person performer, Status status) {
        this.ID = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.creationDate = creationDate;
        this.executionDate = executionDate;
        this.author = author;
        this.performer = performer;
        this.status = status;
    }

    public Task(String title, String description, Priority priority, LocalDate creationDate, LocalDate executionDate,
                Person author, Person performer) {
        this.ID = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.creationDate = creationDate;
        this.executionDate = executionDate;
        this.author = author;
        this.performer = performer;
        this.status = Status.START;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public Person getPerformer() {
        return performer;
    }

    public void setPerformer(Person performer) {
        this.performer = performer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj != this.getClass()) return false;
        Task other = (Task) obj;
        return other.getID().equals(this.ID)
                && (other.getTitle().equals(this.title)
                && (other.getDescription().equals(this.description))
                && (other.getPriority() == this.priority)
                && (other.getCreationDate() == this.creationDate)
                && (other.getExecutionDate() == this.executionDate)
                && (other.getAuthor().equals(this.author))
                && (other.getPerformer().equals(this.performer))
                && (other.getStatus() == this.status)
        );
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime * Objects.hash(ID, title, description, priority, creationDate, executionDate, priority,
                status, performer, author);
    }

    @Override
    public String toString() {
        return "model.Task{" +
                "ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", creationDate=" + creationDate +
                ", executionDate=" + executionDate +
                ", author='" + author + '\'' +
                ", performer='" + performer + '\'' +
                ", status=" + status +
                '}';
    }
}
