package com.gmail.alinakotova102.dao.task;

import com.gmail.alinakotova102.model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Классы которые имплементируют ДАО должны быть сырыми и без какой-либо
 * проверки на полученные данные
 * Вся проверка происходит в классах сервисах
 */
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
        return tasks.stream()
                .filter(obj -> obj.equals(task))
                .toString();
    }

    @Override
    public void update(Task taskOld, Task taskNew) {
        tasks.set(tasks.indexOf(taskOld), taskNew);
    }

    @Override
    public void delete(Task task) {
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