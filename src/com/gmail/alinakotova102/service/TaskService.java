package com.gmail.alinakotova102.service;

import com.gmail.alinakotova102.dao.person.PersonDAOImpl;
import com.gmail.alinakotova102.dao.task.TaskDAOImpl;
import com.gmail.alinakotova102.exception.NotFoundException;
import com.gmail.alinakotova102.model.Person;
import com.gmail.alinakotova102.model.Priority;
import com.gmail.alinakotova102.model.Task;
import com.gmail.alinakotova102.util.DisplayUtil;
import com.gmail.alinakotova102.util.ScannerUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TaskService {
    private TaskDAOImpl taskDAO;
    private PersonService personService;

    public TaskService() {
    }

    public TaskService(TaskDAOImpl taskDAO) {
        this.taskDAO = taskDAO;
    }

    public void addTask() throws NotFoundException {
        String taskName = askTaskName();
        String description = askTaskDescription();
        Priority priority = askTaskPriority();
        LocalDate creationDate = askTaskCreationDate();
        LocalDate executionDate = askExecutionDate();
        Person author = personService.addPerson();
        Person performer = personService.addPerson();
        taskDAO.insert(new Task(taskName, description, priority, creationDate, executionDate, author, performer));
    }

    private LocalDate askExecutionDate() {
        return selectDate("Enter execute date");
    }

    private LocalDate askTaskCreationDate() {
        return selectDate("Enter start date");
    }

    private LocalDate selectDate(String message) {
        DisplayUtil.view(message + ": \n1 - Current Date\n2 - Enter your date");
        LocalDate date = null;
        String selectDate = ScannerUtil.response();
        boolean exits = false;
        while (!exits) {
            switch (selectDate) {
                case "1" -> {
                    date = currentDate();
                    exits = true;
                }
                case "2" -> {
                    DisplayUtil.view("Enter date in format year/month/day(example: 2025/12/04):");
                    date = createDate();
                    exits = true;
                }
                default -> {
                    DisplayUtil.view("I don't understand your select :(");
                    selectDate = ScannerUtil.response();
                }
            }
        }
        return date;
    }

    private LocalDate currentDate() {
        return LocalDate.now();
    }

    private LocalDate createDate() {
        String date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDate localDate;
        while (true) {
            try {
                date = ScannerUtil.response();
                localDate = LocalDate.parse(date);
                break;
            } catch (DateTimeParseException e) {
                DisplayUtil.view("I don't understand this date, try entering it again(Example: 2025-01-01)");
            }
        }
        return localDate;
    }

    private String askTaskName() {
        DisplayUtil.view("Enter the task name: ");
        return ScannerUtil.response();
    }

    private String askTaskDescription() {
        DisplayUtil.view("Enter the task description: ");
        return ScannerUtil.response();
    }

    private Priority askTaskPriority() throws NotFoundException {
        DisplayUtil.view("Select priority(1-4): \n1 - FAST\n2 - IMMEDIATE\n3 - HIGH\n4 - URGENT");
        Priority priority = null;
        boolean exists = false;
        String priorityUser = null;
        while (!exists) {
            try {
                priorityUser = ScannerUtil.response();
                switch (priorityUser) {
                    case "1":
                        priority = Priority.FAST;
                        exists = true;
                        break;
                    case "2":
                        priority = Priority.IMMEDIATE;
                        exists = true;
                        break;
                    case "3":
                        priority = Priority.HIGH;
                        exists = true;
                        break;
                    case "4":
                        priority = Priority.URGENT;
                        exists = true;
                        break;
                    default:
                        throw new NotFoundException();
                }
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return priority;
    }
}