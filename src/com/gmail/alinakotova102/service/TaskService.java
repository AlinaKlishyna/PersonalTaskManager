package com.gmail.alinakotova102.service;

import com.gmail.alinakotova102.api.dao.impl.TaskDAOImpl;
import com.gmail.alinakotova102.exception.DataException;
import com.gmail.alinakotova102.model.Person;
import com.gmail.alinakotova102.model.Priority;
import com.gmail.alinakotova102.model.Status;
import com.gmail.alinakotova102.model.Task;

import java.time.LocalDate;

public class TaskService {
    private final TaskDAOImpl taskDAO = TaskDAOImpl.getInstance();

    private static TaskService unique;

    private TaskService() {

    }

    public static TaskService getInstance() {
        if (unique == null) unique = new TaskService();
        return unique;
    }

    public void addTask(Task task) throws DataException {
        if (task != null && checkTask(
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getCreationDate(),
                task.getExecutionDate(),
                task.getAuthor(),
                task.getPerformer(),
                task.getStatus()
        ))
            taskDAO.insert(task);
    }

    private boolean checkTask(String title, String description, Priority priority, LocalDate creationDate,
                              LocalDate executionDate, Person author, Person performer,
                              Status status) throws DataException {
        return checkTitle(title)
                && checkDescription(description)
                && priority != null
                && checkDate(creationDate, executionDate)
                && author != null
                && performer != null
                && status != null;
    }

    private boolean checkDate(LocalDate creationDate, LocalDate executionDate) throws DataException {
        if (executionDate.isBefore(creationDate))
            throw new DataException("The end date must not be earlier than the start date.", executionDate.toString());
        return true;
    }

    private boolean checkTitle(String title) {
        return title!= null && !title.matches("\\s+") && title.matches(".{1,50}");
    }

    private boolean checkDescription(String description) {
        return description!= null && !description.matches("\\s+") && description.matches(".{1,100}");
    }
}