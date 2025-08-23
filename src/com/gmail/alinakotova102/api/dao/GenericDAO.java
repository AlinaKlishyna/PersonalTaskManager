package com.gmail.alinakotova102.api.dao;

import com.gmail.alinakotova102.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Общие методы, которые могут встретиться при работе с данными
 *
 * @param <T>
 */
public interface GenericDAO<T> {
    public void insert(T t);

    public T read(UUID id);

    public void update(T t);

    public void delete(T t);

    public Optional<T> get(T t);

    public List<T> getAll();
}