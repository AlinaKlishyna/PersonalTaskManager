package com.gmail.alinakotova102.dao;

import com.gmail.alinakotova102.exception.NotFoundException;

import java.util.List;

/**
 * Общие методы, которые могут встретиться при работе с данными
 *
 * @param <T>
 */
public interface DAO<T> {
    public void insert(T t);

    public String read(T t);

    public void update(T t);

    public void delete(T t) throws NotFoundException;

    public T get(T t);

    public List<T> getAll();
}