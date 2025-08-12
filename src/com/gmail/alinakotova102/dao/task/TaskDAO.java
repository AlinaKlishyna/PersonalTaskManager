package com.gmail.alinakotova102.dao.task;

import com.gmail.alinakotova102.dao.DAO;
import com.gmail.alinakotova102.model.Task;

import java.util.List;

public interface TaskDAO extends DAO<Task> {
    public void displaySortName(List<Task> task);
    public void displaySortLastName(List<Task> task);
    public void displaySortCreationDate(List<Task> task);
    public void displaySortExecutionDate(List<Task> task);
    public void editTask(Task task);
    public void completeMark(Task task);
}
