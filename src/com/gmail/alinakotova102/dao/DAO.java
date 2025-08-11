package com.gmail.alinakotova102.dao;

import java.util.List;

/**
 * Общие методы, которые могут встретиться при работе с данными
 *
 * @param <T>
 */
public interface DAO<T> {
    public void insert(T t);

    public String read(String path);

    public void update(T t);

    public void delete(T t);

    public T get(T t);

    public List<T> getAll();
}