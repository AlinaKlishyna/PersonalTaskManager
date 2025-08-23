package com.gmail.alinakotova102.serialization;

import com.gmail.alinakotova102.model.Task;

import java.io.*;

/**
 * Serializable - маркерный интерфейс
 * это интерфейс, который не содержит методов, но при этом помечает этот класс
 */
public class TaskSerializer {

    public void serialize(Task task, String path) {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(path))) {
            obj.writeObject(task);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Task deserialize(String path) {
        Task task = new Task();
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(path))) {
            Object objectByFile = obj.readObject();
            if (objectByFile instanceof Task) {
                task = (Task) objectByFile;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return task;
    }
}