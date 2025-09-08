package com.gmail.alinakotova102.service;

import com.gmail.alinakotova102.api.dao.impl.TaskDAOImpl;
import com.gmail.alinakotova102.exception.DataException;
import com.gmail.alinakotova102.exception.DateTaskException;
import com.gmail.alinakotova102.model.Priority;
import com.gmail.alinakotova102.model.Status;
import com.gmail.alinakotova102.model.Task;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class TaskService {
    private final TaskDAOImpl taskDAO = TaskDAOImpl.getInstance();

    private static TaskService unique;

    private TaskService() {

    }

    public static TaskService getInstance() {
        if (unique == null) unique = new TaskService();
        return unique;
    }

    public void addTask(Task task) throws DataException, DateTaskException {
        if (task != null) {
            checkTask(task);
            taskDAO.insert(task);
        }
    }

    public void editMark(Task task, Priority priority) throws DataException, DateTaskException {
        if (task == null) throw new DataException("Task cannot be null!", null);
        task.setPriority(priority);
        editTask(task);
    }

    public List<Task> filterPriority(Priority priority) throws DataException {
        if (priority == null) throw new DataException("Priority cannot be null!", null);
        return taskDAO.getAll().stream().filter(task -> task.getPriority().equals(priority)).toList();
    }

    public List<Task> filterExecutionDate() throws DataException {
        if (taskDAO == null) throw new DataException("Execution Date cannot be null!", null);
        return taskDAO.getAll().stream()
                .filter(task -> task.getStatus() != Status.COMPLETED)
                .sorted(Comparator.comparing(Task::getExecutionDate))
                .toList();
    }

    public List<Task> viewTasks() {
        return taskDAO.getAll().stream().sorted(Comparator.comparing(Task::getPriority)).toList();
    }

    public void editTask(Task task) throws DataException, DateTaskException {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        checkTask(task);
        taskDAO.update(task);
    }

    private void checkTask(Task task) throws DataException, DateTaskException {
        checkNotNull(task);
        checkTitle(task.getTitle());
        checkDescription(task.getDescription());
        checkDate(task.getCreationDate(), task.getExecutionDate());
    }

    private void checkNotNull(Task task) throws DataException {
        if (task.getTitle() == null) throw new DataException("Title cannot be null!", null);
        if (task.getDescription() == null) throw new DataException("Description cannot be null!", null);
        if (task.getPriority() == null) throw new DataException("Priority cannot be null!", null);
        if (task.getAuthor() == null) throw new DataException("Author cannot be null!", null);
        if (task.getPerformer() == null) throw new DataException("Performer cannot be null!", null);
        if (task.getStatus() == null) throw new DataException("Status cannot be null!", null);
        if (task.getCreationDate() == null) throw new DataException("Creation Date cannot be null!", null);
        if (task.getExecutionDate() == null) throw new DataException("Execution Date cannot be null!", null);
    }

    private boolean checkDate(LocalDate creationDate, LocalDate executionDate) throws DateTaskException {
        if (executionDate.isBefore(creationDate))
            throw new DateTaskException(creationDate, executionDate);
        return true;
    }

    private boolean checkTitle(String title) throws DataException {
        if (title != null && !title.matches("\\s+") && title.matches(".{1,50}"))
            return true;
        throw new DataException("Title is incorrect!", title);
    }

    private boolean checkDescription(String description) throws DataException {
        if (description != null && !description.matches("\\s+") && description.matches(".{1,100}"))
            return true;
        throw new DataException("Description is incorrect!", description);
    }
}