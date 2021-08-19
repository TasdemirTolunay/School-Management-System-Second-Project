package dev.patika.schoolmanagement.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseRepository<T> {

    List<T> findAll();
    T findById(int id);
    T save(T object);
    void delete(T object);
    void deleteById(int id);
    void update(T object, int id);

}
