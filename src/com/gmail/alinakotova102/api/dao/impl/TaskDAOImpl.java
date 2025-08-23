package com.gmail.alinakotova102.api.dao.impl;

import com.gmail.alinakotova102.api.dao.TaskDAO;
import com.gmail.alinakotova102.model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Классы которые имплементируют ДАО должны быть сырыми и без какой-либо
 * проверки на полученные данные
 * Вся проверка происходит в классах сервисах
 */
public class TaskDAOImpl implements TaskDAO {
    private static TaskDAOImpl instance;
    private List<Task> tasks = new ArrayList<>();

    private TaskDAOImpl() {
    }

    public static TaskDAOImpl getInstance() {
        if (instance == null) {
            instance = new TaskDAOImpl();
        }
        return instance;
    }

    @Override
    public void insert(Task task) {
        tasks.add(task);
    }

    @Override
    public Task read(UUID id) {
        return tasks.stream()
                .filter(obj -> obj.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public void update(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(task.getId())) {
                tasks.set(i, task);
                return;
            }
        }
    }

    @Override
    public void delete(Task task) {
        if (tasks.contains(task))
            tasks.remove(task);
    }

    /**
     * Класс Optional нужен для того, что результата может и не быть, то есть
     * вернуть null, дальнейшая его обработка должна быть в классе сервисе
     */
    @Override
    public Optional<Task> get(Task task) {
        return tasks.stream()
                .filter(obj -> obj.equals(task))
                .findAny();
    }

    @Override
    public List<Task> getAll() {
        return tasks;
    }
}