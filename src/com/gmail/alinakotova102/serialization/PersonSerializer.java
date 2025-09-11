package com.gmail.alinakotova102.serialization;

import com.gmail.alinakotova102.model.Person;

import java.io.*;
import java.util.ArrayList;

/**
 * Serializable - маркерный интерфейс
 * это интерфейс, который не содержит методов, но при этом помечает этот класс
 */
public class PersonSerializer {
    public static void serialize(ArrayList<Person> persons, String path) {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(path))) {
            obj.writeObject(persons);
        } catch (FileNotFoundException e) {
            System.out.println("File " + e.getMessage() + " non found!");
        } catch (IOException e) {
            System.out.println("Error while reading file: " + path);
        }
    }

    public static ArrayList<Person> deserialize(String path) {
        ArrayList<Person> persons = new ArrayList<>();
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(path))) {
            ArrayList<Object> objects = (ArrayList<Object>) obj.readObject();
            for (Object object : objects) {
                if (object instanceof Person) persons.add((Person) object);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + e.getMessage() + " non found!");
        } catch (ClassNotFoundException e) {
            System.out.println("The class " + e.getMessage() + " was not found");
        } catch (IOException e) {
            System.out.println("Error while reading file: " + path);
        }
        return persons;
    }
}