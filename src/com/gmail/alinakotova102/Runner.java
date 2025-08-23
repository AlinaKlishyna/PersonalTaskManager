package com.gmail.alinakotova102;

import com.gmail.alinakotova102.exception.NotFoundException;
import com.gmail.alinakotova102.model.Person;

public class Runner {
    public static void main(String[] args) throws NotFoundException {
        Person p1 = new Person("Владислав", "Лисяк", "doublefmove@gmail.com");
        Person p2 = new Person("Алина", "Клишина", "alinakotova102@gmail.com");
        Person p3 = new Person("Василиса", "Бермудов", "vasilisa200@gmail.com");
        Person p4 = new Person("Василий", "Славко", "vas2020@gmail.com");
        Person p5 = new Person("Женя", "Одесев", "jenyaodesev@mail.ru");
    }
}