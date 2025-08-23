package com.gmail.alinakotova102.serialization;

import com.gmail.alinakotova102.model.Person;
import com.gmail.alinakotova102.model.Task;

import java.io.*;

public class PersonSerializer{

    public void serialize(Person person, String path) {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(path))) {
            obj.writeObject(person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Person deserialize(String path) {
        Person person = new Person();
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(path))) {
            Object objectByFile = obj.readObject();
            if (objectByFile instanceof Task) {
                person = (Person) objectByFile;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
}