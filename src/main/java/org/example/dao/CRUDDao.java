package org.example.dao;

import java.util.Optional;

public interface CRUDDao<T, ID> {

    Optional<T> findById(ID id);
    T save(T entity);
    T update(T entity);
    T delete(T entity);
}
