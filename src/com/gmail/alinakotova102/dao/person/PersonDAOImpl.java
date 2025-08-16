package com.gmail.alinakotova102.dao.person;

import com.gmail.alinakotova102.exception.NotFoundException;
import com.gmail.alinakotova102.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDAOImpl implements PersonDAO {
    private static PersonDAOImpl uniqueInstance;
    private List<Person> persons = new ArrayList<>();

    private PersonDAOImpl() {
    }

    public static PersonDAOImpl getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new PersonDAOImpl();
        }
        return uniqueInstance;
    }

    @Override
    public void insert(Person person) {
        if (person != null) persons.add(person);
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
        persons = persons.stream()
                .map(person -> {
                    if (person.equals(personOld)) person = personNew;
                    return person;
                })
                .toList();
    }

    @Override
    public void delete(Person person) throws NotFoundException {
        if (person != null) persons.remove(person);
    }

    @Override
    public Person get(Person person) {
        return persons.stream()
                .filter(obj -> obj.equals(person))
                .findFirst()
                .get();
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