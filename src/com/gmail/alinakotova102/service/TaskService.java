package com.gmail.alinakotova102.service;

import com.gmail.alinakotova102.dao.person.PersonDAOImpl;

public class TaskService {
    private PersonDAOImpl personDAOImpl;

    public TaskService(PersonDAOImpl personDAOImpl) {
        this.personDAOImpl = personDAOImpl;
    }


}
