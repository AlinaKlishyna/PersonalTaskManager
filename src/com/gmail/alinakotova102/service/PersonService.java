package com.gmail.alinakotova102.service;

import com.gmail.alinakotova102.api.dao.impl.PersonDAOImpl;
import com.gmail.alinakotova102.exception.DataException;
import com.gmail.alinakotova102.model.Person;
import com.gmail.alinakotova102.util.ScannerUtil;

public class PersonService {

    private PersonDAOImpl personDAO;

    public PersonService(PersonDAOImpl personDAO) {
        this.personDAO = personDAO;
    }

    public Person addPerson(String firstName, String lastName, String email) throws DataException {
        if (!checkEmail(email)) {
            throw new DataException("Email is incorrect! ", email);
        }
        if (!checkFirstName(firstName)) {
            throw new DataException("First Name is incorrect! ", firstName);
        }
        if (!checkLastName(lastName)) {
            throw new DataException("Last Name is incorrect! ", lastName);
        }
        return new Person(firstName, lastName, email);
    }

    private boolean checkEmail(String email) {
        return email.matches("[a-z0-9]+@\\w+\\.\\w+");
    }

    private boolean checkLastName(String lastName) {
        return lastName.matches("[A-ZА-Я][a-zа-я]{2,}");
    }

    private boolean checkFirstName(String firstName) {
        return firstName.matches("[A-ZА-Я][a-zа-я]{1,}");
    }
}