package com.abdo.repository;

import java.util.*;
import java.util.function.Function;

public class InMemoryRepository<T, ID> implements CrudRepository<T, ID> {

    // Khzana f-l-mémoire: Clé -> ID, Valeur -> Objet T
    private final Map<ID, T> storage = new HashMap<>();

    // Had l-fonction katgol l-l-repository kifach yjbed l-ID mn l-objet T
    private final  Function<T, ID> idExtractor;

    public InMemoryRepository(Function<T, ID> idExtractor) {
        this.idExtractor = idExtractor;
    }

    @Override
    public T save(T entity) {
        ID id = idExtractor.apply(entity);
        storage.put(id, entity);
        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        // Optional.ofNullable kat-rejje3 Optional khawi ila kan null bla crash
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public boolean deleteById(ID id) {
        return storage.remove(id) != null;
    }
}