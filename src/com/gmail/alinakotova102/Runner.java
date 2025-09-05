package com.gmail.alinakotova102;

import com.gmail.alinakotova102.exception.NotFoundException;
import com.gmail.alinakotova102.model.Person;
import com.gmail.alinakotova102.model.Priority;
import com.gmail.alinakotova102.model.Status;
import com.gmail.alinakotova102.model.Task;
import com.gmail.alinakotova102.serialization.PersonSerializer;
import com.gmail.alinakotova102.serialization.TaskSerializer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws NotFoundException {
        Person p1 = new Person("Владислав", "Лисяк", "doublefmove@gmail.com");
        Person p2 = new Person("Алина", "Клишина", "alinakotova102@gmail.com");
        Person p3 = new Person("Василиса", "Бермудов", "vasilisa200@gmail.com");
        Person p4 = new Person("Василий", "Славко", "vas2020@gmail.com");
        Person p5 = new Person("Женя", "Одесев", "jenyaodesev@mail.ru");

        ArrayList<Person> persons = new ArrayList<>(List.of(p1, p2, p3, p4, p5));

        PersonSerializer.serialize(persons, "resources/file/persons.txt");

        ArrayList<Person> personsDes = PersonSerializer.deserialize("resources/file/persons.txt");

        for (Person person : personsDes) {
            System.out.println(person);
        }

        Task t1 = new Task(
                "Task1",
                null,
                Priority.FAST,
                LocalDate.now(),
                LocalDate.of(2025, 6, 12),
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

        for (Task task : tasksBySerializer) {
            System.out.println(task);
        }
    }
}
