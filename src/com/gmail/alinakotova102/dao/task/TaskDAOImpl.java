package com.gmail.alinakotova102.dao.task;

import com.gmail.alinakotova102.exception.NotFoundException;
import com.gmail.alinakotova102.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        if (task != null) tasks.add(task);
    }

    @Override
    public String read(Task task) {
        return tasks.stream()
                .filter(obj -> obj.equals(task))
                .toString();
    }

    @Override
    public void update(Task taskOld, Task taskNew) {
        tasks = tasks.stream()
                .map(obj -> {
                    if (obj.equals(taskOld)) obj = taskNew;
                    return obj;
                }).toList();
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
        return tasks.stream()
                .filter(obj -> obj.equals(task))
                .findAny()
                .get();
    }

    @Override
    public List<Task> getAll() {
        return tasks;
    }
}