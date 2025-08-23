package com.gmail.alinakotova102.api.dao.impl;

import com.gmail.alinakotova102.api.dao.PersonDAO;
import com.gmail.alinakotova102.model.Person;

import java.util.*;

public class PersonDAOImpl implements PersonDAO {
    private static PersonDAOImpl instance;
    private List<Person> persons = new ArrayList<>();

    private PersonDAOImpl() {
    }

    public static PersonDAOImpl getInstance() {
        if (instance == null) {
            instance = new PersonDAOImpl();
        }
        return instance;
    }

    @Override
    public void insert(Person person) {
        persons.add(person);
    }

    @Override
    public Person read(UUID id) {
        return persons.stream()
                .filter(obj -> obj.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public void update(Person person) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).equals(person.getId())) {
                persons.set(i, person);
                return;
            }
        }
    }

    @Override
    public void delete(Person person) {
        if (persons.contains(person))
            persons.remove(person);
    }

    @Override
    public Optional<Person> get(Person person) {
        return persons.stream()
                .filter(obj -> obj.equals(person))
                .findFirst();
    }

    @Override
    public List<Person> getAll() {
        return persons;
    }

    @Override
    public List<Person> sortFirstName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .toList();
    }

    @Override
    public List<Person> sortLastName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .toList();
    }
}