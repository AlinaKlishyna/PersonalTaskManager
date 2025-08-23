package com.gmail.alinakotova102.api.dao;

import com.gmail.alinakotova102.model.Person;

import java.util.List;

/**
 * Конкретные методы, которые могут встретиться при работе с Person
 */
public interface PersonDAO extends GenericDAO<Person> {
    public List<Person> sortFirstName();
    public List<Person> sortLastName();
}
