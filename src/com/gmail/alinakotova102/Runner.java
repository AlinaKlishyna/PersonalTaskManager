package com.gmail.alinakotova102;

import com.gmail.alinakotova102.dao.person.PersonDAOImpl;
import com.gmail.alinakotova102.exception.NotFoundException;
import com.gmail.alinakotova102.model.Person;

public class Runner {
    public static void main(String[] args) throws NotFoundException {
        /*List<Task> tasks = new ArrayList<>();
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
*/
        Person p1 =  new Person("Владислав", "Лисяк", "doublefmove@gmail.com");
        Person p2 =  new Person("Алина", "Клишина", "alinakotova102@gmail.com");
        Person p3 =  new Person("Василиса", "Бермудов", "vasilisa200@gmail.com");
        Person p4 = new Person("Василий", "Славко", "vas2020@gmail.com");
        Person p5 = new Person("Женя", "Одесев", "jenyaodesev@mail.ru");
        PersonDAOImpl personDAO = PersonDAOImpl.getInstance();
        personDAO.insert(p1);
        personDAO.insert(p2);
        personDAO.insert(p3);
        personDAO.insert(p4);
        personDAO.insert(p5);

        System.out.println(personDAO.getAll());
        personDAO.update(p1, p2);
        System.out.println(personDAO.getAll());

        TaskService task = TaskService.getInstance();

    }
}