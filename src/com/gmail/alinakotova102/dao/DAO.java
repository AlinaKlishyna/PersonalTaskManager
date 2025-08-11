package com.gmail.alinakotova102.dao;

import java.util.List;

/**
 * Общие методы, которые могут встретиться при работе с данными
 * @param <T>
 */
public interface DAO<T> {
    void insert(T t);
    String read(String path);
    void update(T t);
    void delete(T t);
    T get(T t);
    List<T> getAll();
}