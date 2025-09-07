package com.gmail.alinakotova102.service;

import com.gmail.alinakotova102.api.dao.impl.PersonDAOImpl;
import com.gmail.alinakotova102.exception.DataException;
import com.gmail.alinakotova102.model.Person;

public class PersonService {

    private final PersonDAOImpl personDAO = PersonDAOImpl.getInstance();
    private static PersonService unique;

    private PersonService() {

    }

    public static PersonService getInstance() {
        if (unique == null) unique = new PersonService();
        return unique;
    }

    public Person addPerson(Person person) throws DataException {
        if (!checkEmail(person.getEmail())) {
            throw new DataException("Email is incorrect! ", person.getEmail());
        }
        if (!checkFirstName(person.getFirstName())) {
            throw new DataException("First Name is incorrect! ", person.getFirstName());
        }
        if (!checkLastName(person.getLastName())) {
            throw new DataException("Last Name is incorrect! ", person.getLastName());
        }
        return new Person(person.getFirstName(), person.getLastName(), person.getEmail());
    }

    private boolean checkEmail(String email) {
        return email.matches("[a-z0-9]+@\\w+\\.\\w{2,4}");
    }

    private boolean checkLastName(String lastName) {
        return lastName.matches("[A-ZА-Я][a-zа-я]{2,}");
    }

    private boolean checkFirstName(String firstName) {
        return firstName.matches("[A-ZА-Я][a-zа-я]{1,}");
    }
}