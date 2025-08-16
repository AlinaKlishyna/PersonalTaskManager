package com.gmail.alinakotova102.serialization;

import java.util.List;

public interface Serializer<T> {
    void serialize(T t, String path);

    T deserialize(String path);
}