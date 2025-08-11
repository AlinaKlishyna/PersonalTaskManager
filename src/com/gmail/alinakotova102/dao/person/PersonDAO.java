package com.gmail.alinakotova102.dao.person;

import com.gmail.alinakotova102.dao.DAO;
import com.gmail.alinakotova102.model.Person;

import java.util.List;

/**
 * Конкретные методы, которые могут встретиться при работе с Person
 */
public interface PersonDAO extends DAO<Person> {
    List<Person> findByID();
    List<Person> findByName();
    List<Person> findByLastName();
    List<Person> findByEmail();
}
