package com.gmail.alinakotova102.dao.person;

import com.gmail.alinakotova102.model.Person;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
    public String read(Person person) {
        return persons.stream()
                .filter(obj -> obj.equals(person))
                .findFirst()
                .toString();
    }

    @Override
    public void update(Person personOld, Person personNew) {
        persons.set(persons.indexOf(personOld), personNew);
    }

    @Override
    public void delete(Person person) {
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