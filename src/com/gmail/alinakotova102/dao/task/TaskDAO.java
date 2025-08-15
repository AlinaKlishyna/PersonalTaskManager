package com.gmail.alinakotova102.dao.task;

import com.gmail.alinakotova102.dao.DAO;
import com.gmail.alinakotova102.model.Task;

public interface TaskDAO extends DAO<Task> {
    public Task findByName(String name);

    public Task findAuthor(String author);
}
