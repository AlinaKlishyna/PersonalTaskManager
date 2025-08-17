package com.gmail.alinakotova102.dao;

import java.util.List;
import java.util.Optional;

/**
 * Общие методы, которые могут встретиться при работе с данными
 *
 * @param <T>
 */
public interface DAO<T> {
    public void insert(T t);

    public String read(T t);

    public void update(T tOld, T tNew);

    public void delete(T t);

    public Optional<T> get(T t);

    public List<T> getAll();
}