package com.gmail.alinakotova102;

import com.gmail.alinakotova102.dao.task.TaskDAOFile;
import com.gmail.alinakotova102.model.Person;
import com.gmail.alinakotova102.model.Priority;
import com.gmail.alinakotova102.model.Status;
import com.gmail.alinakotova102.model.Task;
import com.gmail.alinakotova102.util.DisplayUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(
                "Запомнить паттерн DAO",
                "почитать в гугл",
                Priority.HIGH,
                LocalDate.now(),
                LocalDate.of(2025, 12, 12),
                new Person("Василий", "Славко", "vas2020@gmail.com"),
                new Person("Женя", "Одесев", "jenyaodesev@mail.ru")));

        tasks.add(new Task(
                "Изучить паттерн Репозиторий",
                "почитать в StackOverflow",
                Priority.IMMEDIATE,
                LocalDate.now(),
                LocalDate.of(2025, 9, 25),
                new Person("Василиса", "Бермудов", "vasilisa200@gmail.com"),
                new Person("Альна", "Шантун", "alyonka11@mail.ru"),
                Status.PROCESS));

        tasks.add(new Task(
                "Спринг изучить",
                "книга \"Spring Boot по-быстрому - Марк Хеклер\"",
                Priority.URGENT,
                LocalDate.now(),
                LocalDate.of(2026, 1, 1),
                new Person("Владислав", "Лисяк", "doublefmove@gmail.com"),
                new Person("Алина", "Клишина", "alinakotova102@gmail.com")));

        TaskDAOFile taskDAOFile = TaskDAOFile.getInstance();
        DisplayUtil.console(taskDAOFile.getAll().toString());
    }
}
