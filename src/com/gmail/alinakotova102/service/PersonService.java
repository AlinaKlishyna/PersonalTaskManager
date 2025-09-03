package com.gmail.alinakotova102.service;

import com.gmail.alinakotova102.dao.person.PersonDAOImpl;
import com.gmail.alinakotova102.model.Person;
import com.gmail.alinakotova102.util.ScannerUtil;

public class PersonService {
    /**
     * public Person findByID(String ID);
     * <p>
     * public List<Person> findByName();
     * <p>
     * public Person findByFirstName(String firstName);
     * <p>
     * public List<Person> findByEmail();

    /*public Person findByID(String ID) {
        return persons.stream()
                .filter(obj -> obj.getID().equals(ID))
                .findAny()
                .get();
    }
    */

    private PersonDAOImpl personDAO;

    public PersonService(PersonDAOImpl personDAO) {
        this.personDAO = personDAO;
    }

    public Person addPerson() {
        String firstName = askFirstName();
        String lastName = askLastName();
        String email = askEmail();
        return new Person(firstName, lastName, email);
    }

    private String askEmail() {
        return ScannerUtil.response();
    }

    private String askLastName() {
        return ScannerUtil.response();
    }

    private String askFirstName() {
        return ScannerUtil.response();
    }
}