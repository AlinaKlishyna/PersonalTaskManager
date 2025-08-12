package com.gmail.alinakotova102.dao.person;

import com.gmail.alinakotova102.model.Person;

import java.util.List;

public class PersonDAOFile implements PersonDAO {
    private static PersonDAOFile uniqueInstance;

    private PersonDAOFile() {
    }

    public static PersonDAOFile getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new PersonDAOFile();
        }
        return uniqueInstance;
    }

    @Override
    public void insert(Person person) {

    }

    @Override
    public String read(Person person) {
        return null;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public Person get(Person person) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public List<Person> findByID() {
        return null;
    }

    @Override
    public List<Person> findByName() {
        return null;
    }

    @Override
    public List<Person> findByLastName() {
        return null;
    }

    @Override
    public List<Person> findByEmail() {
        return null;
    }
}
