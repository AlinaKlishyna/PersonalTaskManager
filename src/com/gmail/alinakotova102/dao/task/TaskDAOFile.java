package com.gmail.alinakotova102.dao.task;

import com.gmail.alinakotova102.model.Task;

import java.util.List;

public class TaskDAOFile implements TaskDAO{
    private static TaskDAOFile uniqueInstance;

    private TaskDAOFile() {}

    public static TaskDAOFile getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new TaskDAOFile();
        }
        return uniqueInstance;
    }

    @Override
    public void insert(Task task) {
        
    }

    @Override
    public String read(String path) {
        return null;
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void delete(Task task) {

    }

    @Override
    public Task get(Task task) {
        return null;
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public Task findByName(String name) {
        return null;
    }

    @Override
    public Task findAuthor(String author) {
        return null;
    }
}
