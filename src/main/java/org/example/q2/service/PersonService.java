package org.example.q2.service;

import org.example.q2.entity.Person;

import java.util.List;

public interface PersonService<T extends Person> {
    Person signUp(String firstName, String lastName);
    void delete(Integer id);
    void update(T person,Integer id);
    List<T> loadAll();
    boolean contains(String firstName, String lastName);
    T findById(Integer id);
}
