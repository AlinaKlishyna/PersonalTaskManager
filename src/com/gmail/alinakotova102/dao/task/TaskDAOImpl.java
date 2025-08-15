package com.gmail.alinakotova102.dao.task;

import com.gmail.alinakotova102.exception.NotFoundException;
import com.gmail.alinakotova102.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {
    private static TaskDAOImpl uniqueInstance;
    private List<Task> tasks = new ArrayList<>();

    private TaskDAOImpl() {
    }

    private TaskDAOImpl(List<Task> tasks) {
        this.tasks = tasks;
    }

    public static TaskDAOImpl getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new TaskDAOImpl();
        }
        return uniqueInstance;
    }

    @Override
    public void insert(Task task) {
        tasks.add(task);
    }

    @Override
    public String read(Task task) {
        return (task != null) ? task.toString() : null;
    }

    @Override
    public void update(Task task) {
        // что сюда пишем?
    }

    @Override
    public void delete(Task task) throws NotFoundException {
        if (task != null) {
            boolean check = false;
            for (Task item : tasks) {
                if (item.equals(task)) {
                    check = true;
                    tasks.remove(item);
                }
            }
            if (!check) {
                throw new NotFoundException(task);
            }
        }
    }

    @Override
    public Task get(Task task) {
        Task taskSearch = new Task();
        for (Task item : tasks) {
            if (item.equals(task)) {
                taskSearch = item;
            }
        }
        return taskSearch;
    }

    @Override
    public List<Task> getAll() {
        return tasks;
    }

    @Override
    public void displaySortName(List<Task> task) {

    }

    @Override
    public void displaySortLastName(List<Task> task) {

    }

    @Override
    public void displaySortCreationDate(List<Task> task) {

    }

    @Override
    public void displaySortExecutionDate(List<Task> task) {

    }

    @Override
    public void editTask(Task task) {

    }

    @Override
    public void completeMark(Task task) {

    }
}
