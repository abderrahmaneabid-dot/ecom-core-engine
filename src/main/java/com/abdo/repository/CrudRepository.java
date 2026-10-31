package com.abdo.repository;

import java.util.List;
import java.util.Optional;

// Generics: T howa no3 l-Objet, ID howa no3 l-Clé
public interface CrudRepository<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    boolean deleteById(ID id);
}