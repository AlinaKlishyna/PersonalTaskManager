package com.gmail.alinakotova102;

import com.gmail.alinakotova102.exception.DataException;
import com.gmail.alinakotova102.exception.DateTaskException;
import com.gmail.alinakotova102.exception.NotFoundException;
import com.gmail.alinakotova102.model.Person;
import com.gmail.alinakotova102.model.Priority;
import com.gmail.alinakotova102.model.Status;
import com.gmail.alinakotova102.model.Task;
import com.gmail.alinakotova102.serialization.PersonSerializer;
import com.gmail.alinakotova102.serialization.TaskSerializer;
import com.gmail.alinakotova102.service.PersonService;
import com.gmail.alinakotova102.service.TaskService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws NotFoundException, DataException, DateTaskException {
        Person p1 = new Person("Владислав", "Лис", "doublefmove@gmail.com");
        Person p2 = new Person("Алина", "Клишина", "alinakotova102@gmail.com");
        Person p3 = new Person("Василиса", "Бермудов", "vasilisa200@gmail.com");
        Person p4 = new Person("Василий", "Славко", "vas2020@gmail.com");
        Person p5 = new Person("Женя", "Одесев", "jenyaodesev@mail.ru");

        ArrayList<Person> persons = new ArrayList<>(List.of(p1, p2, p3, p4, p5));

        PersonSerializer.serialize(persons, "resources/file/persons.txt");

        ArrayList<Person> personsDes = PersonSerializer.deserialize("resources/file/persons.txt");

        System.out.println("\nTesting.. Deserializer Persons -------------->");
        for (Person person : personsDes) {
            System.out.println(person);
        }

        Task t1 = new Task(
                "Task1",
                "null",
                Priority.URGENT,
                LocalDate.now(),
                LocalDate.of(2026, 12, 12),
                p1,
                p1,
                Status.PROCESS);
        Task t2 = new Task(
                "Task2",
                ".....",
                Priority.IMMEDIATE,
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2026, 2, 2),
                p5,
                p2,
                Status.START);
        Task t3 = new Task(
                "Task3",
                "bla-bla",
                Priority.HIGH,
                LocalDate.of(2025, 5, 25),
                LocalDate.of(2025, 9, 3),
                p3,
                p4,
                Status.COMPLETED);

        ArrayList<Task> tasks = new ArrayList<>(List.of(t1, t2, t3));

        TaskSerializer.serialize(tasks, "resources/file/tasks.txt");
        ArrayList<Task> tasksBySerializer = TaskSerializer.deserialize("resources/file/tasks.txt");

        System.out.println("\nTesting.. Deserialize Tasks -------------->");
        for (Task task : tasksBySerializer) {
            System.out.println(task);
        }

        System.out.println("\nTesting.. PersonService -------------->");
        PersonService personService = PersonService.getInstance();
        for (Person person : persons) {
            personService.addPerson(person);
        }

        System.out.println("\nTesting.. TaskService -------------->");
        TaskService taskService = TaskService.getInstance();
        for (Task task : tasks) {
            taskService.addTask(task);
        }

        List<Task> tasksByDAO = taskService.viewTasks();
        for (Task task : tasksByDAO) {
            System.out.println(task);
        }
    }
}
