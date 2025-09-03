package com.gmail.alinakotova102.service;

import com.gmail.alinakotova102.dao.task.TaskDAOImpl;
import com.gmail.alinakotova102.model.Task;

public class TaskService {
    private final TaskDAOImpl taskDAO = TaskDAOImpl.getInstance();

    private static TaskService unique;

    private TaskService() {
    }

    public static TaskService getInstance() {
        if (unique == null) {
            unique = new TaskService();
        }
        return unique;
    }

    public void addTask(Task task) {
        taskDAO.insert(task);
    }

    
}