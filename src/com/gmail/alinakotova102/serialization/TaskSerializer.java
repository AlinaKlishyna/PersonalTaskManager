package com.gmail.alinakotova102.serialization;

import com.gmail.alinakotova102.model.Task;

import java.io.*;
import java.util.ArrayList;

/**
 * Serializable - маркерный интерфейс
 * это интерфейс, который не содержит методов, но при этом помечает этот класс
 */
public class TaskSerializer {

    public static void serialize(ArrayList<Task> task, String path) {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(path))) {
            obj.writeObject(task);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Task> deserialize(String path) {
        ArrayList<Task> task = new ArrayList<>();
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(path))) {
            ArrayList<Object> objects = (ArrayList<Object>) obj.readObject();
            for (Object object : objects) {
                if (object instanceof Task) {
                    task.add((Task) object);
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return task;
    }
}